package ro.androidiasi.codecamp.about;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;

import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;

import ro.androidiasi.codecamp.BuildConfig;
import ro.androidiasi.codecamp.R;

/**
 * Created by andrei on 20/04/16.
 */
@EBean
public class AboutPresenter implements AboutContract.Presenter {

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
        Uri webpage = Uri.parse("https://github.com/AndroidIasi/Codecamp");
        Intent webIntent = new Intent(Intent.ACTION_VIEW, webpage);

        String title = mContext.getString(R.string.choser_favorite_app);
        Intent chooser = Intent.createChooser(webIntent, title);

        if (webIntent.resolveActivity(mContext.getPackageManager()) != null) {
            mContext.startActivity(chooser);
        } else {
            Toast.makeText(mContext, R.string.please_install_browser, Toast.LENGTH_SHORT).show();
        }
    }
}
