package ro.androidiasi.codecamp.sessions;

import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ItemClick;
import org.androidannotations.annotations.ViewById;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

import ro.androidiasi.codecamp.BaseFragment;
import ro.androidiasi.codecamp.R;
import ro.androidiasi.codecamp.about.EventRefreshLists;
import ro.androidiasi.codecamp.internal.model.Session;
import se.emilsjolander.stickylistheaders.StickyListHeadersListView;

/**
 * Created by andrei on 08/04/16.
 */
@EFragment
public abstract class BaseSessionsFragment extends BaseFragment implements
        SwipeRefreshLayout.OnRefreshListener, SessionsContract.View {

    @Bean public SessionsAdapter mSessionsAdapter;

    @ViewById(R.id.swipe_to_refresh) public SwipeRefreshLayout mSwipeRefreshLayout;
    @ViewById(R.id.list_view) public StickyListHeadersListView mListView;
    @ViewById(R.id.empty_list_text) public TextView mEmptyListTextView;

    protected abstract SessionsContract.Presenter getPresenter();

    @Override public void afterViews() {
        super.afterViews();
        this.mListView.setAdapter(mSessionsAdapter);
        this.mSwipeRefreshLayout.setColorSchemeResources(
                R.color.holo_blue_bright,
                R.color.holo_green_light,
                R.color.holo_orange_light,
                R.color.holo_red_light);
        this.mSwipeRefreshLayout.setOnRefreshListener(this);
        initPresenter();
    }

    public void initPresenter() {
        this.getPresenter().setView(this);
        this.getPresenter().setRepository(getRepository());
    }

    @Override public void onResume() {
        super.onResume();
        this.getPresenter().start();
        Log.i("Basesession", "fragment resumed");
    }

    @Override public void onDestroy() {
        super.onDestroy();
        this.getPresenter().setView(null);
    }

    @Override public boolean isActive() {
        return isAdded();
    }

    @Override public void onLoad() {
        this.mSwipeRefreshLayout.setRefreshing(true);
    }

    @Override public void onSuccess(List<Session> pSessionList) {
        this.mSwipeRefreshLayout.setRefreshing(false);
        mSessionsAdapter.update(pSessionList);
    }

    @Override public void onFailure() {
        this.mSwipeRefreshLayout.setRefreshing(false);
        Toast.makeText(getActivity(), R.string.failure_load_sessions, Toast.LENGTH_SHORT).show();
    }

    @ItemClick(R.id.list_view) public void onSessionItemClicked(Session pSession){
        this.getNavigator().goToSessionDetails(pSession);
    }

    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void onEventMainThread(EventRefreshLists pEvent){
        this.getPresenter().refreshSessions(true);
    }

    @Override public void onRefresh() {
        getPresenter().refreshSessions(true);
    }
}
