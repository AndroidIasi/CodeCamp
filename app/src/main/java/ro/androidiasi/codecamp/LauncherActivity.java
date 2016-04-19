package ro.androidiasi.codecamp;

import com.facebook.drawee.view.SimpleDraweeView;

import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.ViewById;

/**
 * Created by andrei on 08/04/16.
 */
@EActivity(R.layout.activity_launcher)
public class LauncherActivity extends BaseActivity {

    @ViewById(R.id.drawee) SimpleDraweeView mSimpleDraweeView;

    @Override public void afterViews() {
        super.afterViews();
        this.onUiThreadStartMainActivity();
    }

    @UiThread(delay = 0) public void onUiThreadStartMainActivity(){
        this.getNavigator().goToMainActivity();
//        Uri uri = new Uri.Builder()
//                .scheme(UriUtil.LOCAL_RESOURCE_SCHEME) // "res"
//                .path(String.valueOf(R.drawable.iasi))
//                .build();
//        this.mSimpleDraweeView.setImageURI(uri);
    }
}
