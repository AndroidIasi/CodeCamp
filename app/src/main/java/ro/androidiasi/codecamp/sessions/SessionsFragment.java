package ro.androidiasi.codecamp.sessions;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EFragment;

import ro.androidiasi.codecamp.R;

/**
 * Created by andrei on 08/04/16.
 */
@EFragment(R.layout.fragment_sessions_list)
public class SessionsFragment extends BaseSessionsFragment implements SessionsContract.View {

    @Bean public SessionsPresenter mSessionsPresenter;

    public static SessionsFragment newInstance() {
        return SessionsFragment_.builder().build();
    }

    @Override protected SessionsContract.Presenter getPresenter() {
        return mSessionsPresenter;
    }
}
