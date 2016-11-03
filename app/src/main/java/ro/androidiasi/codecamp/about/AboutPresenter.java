package ro.androidiasi.codecamp.about;

import android.content.Context;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;

import ro.androidiasi.codecamp.BuildConfig;
import ro.androidiasi.codecamp.Navigator;
import ro.androidiasi.codecamp.R;

/**
 * Created by andrei on 20/04/16.
 */
@EBean
public class AboutPresenter implements AboutContract.Presenter {

    @Bean Navigator mNavigator;
    @RootContext Context mContext;

    private AboutContract.View mView;

    @Override public void setView(AboutContract.View pView) {
        this.mView = pView;
    }

    @Override public void afterViews() {
        String version = mContext.getString(R.string.version,
                BuildConfig.VERSION_NAME,
                BuildConfig.VERSION_CODE);
        this.mView.getVersionTextView().setText(version);
    }

    @Override public void onThisAppIsOpenSourceClicked() {
        mNavigator.goToWebPage("https://github.com/AndroidIasi/Codecamp");
    }
}
