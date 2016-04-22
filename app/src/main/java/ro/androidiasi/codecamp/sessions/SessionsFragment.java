package ro.androidiasi.codecamp.sessions;

import android.support.v4.widget.SwipeRefreshLayout;
import android.widget.TextView;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.IgnoreWhen;
import org.androidannotations.annotations.ItemClick;
import org.androidannotations.annotations.ViewById;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import ro.androidiasi.codecamp.BaseFragment;
import ro.androidiasi.codecamp.R;
import ro.androidiasi.codecamp.internal.model.Session;
import ro.androidiasi.codecamp.main.EventStopSwipeToRefresh;
import se.emilsjolander.stickylistheaders.StickyListHeadersListView;

/**
 * Created by andrei on 08/04/16.
 */
@EFragment(R.layout.fragment_sessions_list)
public class SessionsFragment extends BaseFragment implements SessionsContract.View {

    @Bean public SessionsPresenter mSessionsPresenter;

    @ViewById(R.id.swipe_to_refresh) public SwipeRefreshLayout mSwipeRefreshLayout;
    @ViewById(R.id.list_view) public StickyListHeadersListView mListView;
    @ViewById(R.id.empty_list_text) public TextView mEmptyListTextView;

    public static SessionsFragment newInstance(){
        return SessionsFragment_.builder()
                .build();
    }

    @Override public void afterViews() {
        super.afterViews();
        this.getPresenter().setView(this);
        this.getPresenter().setRepository(getRepository());
        this.getPresenter().afterViews();
    }

    protected SessionsContract.Presenter getPresenter(){
        return this.mSessionsPresenter;
    }

    @Override public StickyListHeadersListView getListView() {
        return this.mListView;
    }

    @Override public TextView getEmptyListTextView() {
        return mEmptyListTextView;
    }

    @Override public SwipeRefreshLayout getSwipeRefreshLayout(){
        return this.mSwipeRefreshLayout;
    }

    @ItemClick(R.id.list_view) public void onSessionItemClicked(Session pSession){
        this.getNavigator().goToSessionDetails(pSession);
    }

    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void onEventMainThread(EventStopSwipeToRefresh pEvent){
        this.mSwipeRefreshLayout.setRefreshing(false);
    }
}
