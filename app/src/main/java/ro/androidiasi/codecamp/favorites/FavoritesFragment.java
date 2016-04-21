package ro.androidiasi.codecamp.favorites;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EFragment;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import ro.androidiasi.codecamp.R;
import ro.androidiasi.codecamp.sessiondetail.EventSessionUpdated;
import ro.androidiasi.codecamp.sessions.SessionsContract;
import ro.androidiasi.codecamp.sessions.SessionsFragment;

/**
 * Created by andrei on 22/04/16.
 */
@EFragment(R.layout.fragment_sessions_list)
public class FavoritesFragment extends SessionsFragment implements FavoritesContract.View{

    @Bean FavoritesPresenter mFavoritesPresenter;

    public static FavoritesFragment newInstance(){
        return FavoritesFragment_.builder()
                .build();
    }

    @Override protected SessionsContract.Presenter getPresenter() {
        return mFavoritesPresenter;
    }

    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void onEventMainThread(EventSessionUpdated pEvent){
        this.mFavoritesPresenter.onEventSessionUpdated();
    }
}
