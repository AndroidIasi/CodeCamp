package ro.androidiasi.codecamp.favorites;

import android.view.View;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EFragment;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

import ro.androidiasi.codecamp.R;
import ro.androidiasi.codecamp.internal.model.Session;
import ro.androidiasi.codecamp.sessiondetail.EventSessionUpdated;
import ro.androidiasi.codecamp.sessions.BaseSessionsFragment;
import ro.androidiasi.codecamp.sessions.SessionsContract;

/**
 * Created by andrei on 22/04/16.
 */
@EFragment(R.layout.fragment_sessions_list)
public class FavoritesFragment extends BaseSessionsFragment implements FavoritesContract.View{

    @Bean FavoritesPresenter mFavoritesPresenter;

    public static FavoritesFragment newInstance(){
        return FavoritesFragment_.builder().build();
    }

    @Override protected SessionsContract.Presenter getPresenter() {
        return mFavoritesPresenter;
    }

    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void onEventMainThread(EventSessionUpdated pEvent){
        this.mFavoritesPresenter.refreshSessions(true);
    }

    @Override public void onSuccess(List<Session> pSessionList) {
        super.onSuccess(pSessionList);
        updateEmptyListViewVisibility();
    }

    @Override public void onFailure() {
        super.onFailure();
        updateEmptyListViewVisibility();
    }

    private void updateEmptyListViewVisibility() {
        mEmptyListTextView.setVisibility(mSessionsAdapter.getCount() == 0 ? View.VISIBLE : View.GONE);
    }
}
