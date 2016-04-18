package ro.androidiasi.codecamp;

import android.content.Context;

import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;

import ro.androidiasi.codecamp.internal.model.Session;
import ro.androidiasi.codecamp.main.MainActivity;
import ro.androidiasi.codecamp.sessiondetail.SessionDetailsActivity;

/**
 * Created by andrei on 06/04/16.
 */
@EBean
public class Navigator {

    @RootContext Context mContext;

    public void goToMainActivity(){
        MainActivity.start(mContext);
    }

    public void goToSessionDetails(Session pSession) {
        SessionDetailsActivity.start(mContext, pSession);
    }
}
