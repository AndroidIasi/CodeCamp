package ro.androidiasi.codecamp;

import android.content.Context;

import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;

import ro.androidiasi.codecamp.main.MainActivity_;

/**
 * Created by andrei on 06/04/16.
 */
@EBean
public class Navigator {

    @RootContext Context mContext;

    public void goToMainActivity(){
        MainActivity_
                .intent(mContext)
                .start();
    }

}
