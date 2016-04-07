package ro.androidiasi.codecamp;

import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.UiThread;

/**
 * Created by andrei on 08/04/16.
 */
@EActivity(R.layout.activity_launcher)
public class LauncherActivity extends BaseActivity {

    @Override public void afterViews() {
        super.afterViews();
        this.onUiThreadStartMainActivity();
    }

    @UiThread(delay = 2000) public void onUiThreadStartMainActivity(){
        this.getNavigator().goToMainActivity();
    }
}
