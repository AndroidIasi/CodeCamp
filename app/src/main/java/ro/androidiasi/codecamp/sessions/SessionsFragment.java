package ro.androidiasi.codecamp.sessions;

import org.androidannotations.annotations.EFragment;

import ro.androidiasi.codecamp.BaseFragment;
import ro.androidiasi.codecamp.R;

/**
 * Created by andrei on 08/04/16.
 */
@EFragment(R.layout.activity_launcher)
public class SessionsFragment extends BaseFragment implements SessionsContract.View {
    public static SessionsFragment newInstance(){
        return SessionsFragment_.builder().build();
    }
}
