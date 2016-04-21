package ro.androidiasi.codecamp.sessions;

import android.support.v4.widget.SwipeRefreshLayout;
import android.widget.TextView;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.FragmentArg;
import org.androidannotations.annotations.ItemClick;
import org.androidannotations.annotations.ViewById;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import ro.androidiasi.codecamp.BaseFragment;
import ro.androidiasi.codecamp.R;
import ro.androidiasi.codecamp.internal.model.Session;
import ro.androidiasi.codecamp.sessiondetail.EventSessionUpdated;
import se.emilsjolander.stickylistheaders.StickyListHeadersListView;

/**
 * Created by andrei on 08/04/16.
 */
@EFragment(R.layout.fragment_sessions_list)
public class SessionsFragment extends BaseFragment implements SessionsContract.View {

    @Bean SessionsPresenter mSessionsPresenter;
    @FragmentArg Boolean mShowOnlyFavoriteSessions = Boolean.FALSE;

    @ViewById(R.id.swipe_to_refresh) SwipeRefreshLayout mSwipeRefreshLayout;
    @ViewById(R.id.list_view) StickyListHeadersListView mListView;
    @ViewById(R.id.empty_list_text) TextView mEmptyListTextView;

    public static SessionsFragment newInstance(){
        return newInstance(false);
    }

    public static SessionsFragment newInstance(boolean pShowOnlyFavorites){
        return SessionsFragment_.builder()
                .mShowOnlyFavoriteSessions(pShowOnlyFavorites)
                .build();
    }

    @Override public void afterViews() {
        super.afterViews();
        this.mSessionsPresenter.setView(this);
        this.mSessionsPresenter.setRepository(getRepository());
        this.mSessionsPresenter.setShowOnlyFavoriteSessions(mShowOnlyFavoriteSessions);
        this.mSessionsPresenter.afterViews();
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
    public void onEventMainThread(EventSessionUpdated pEvent){
        this.mSessionsPresenter.onEventSessionUpdated();
    }
}
