package ro.androidiasi.codecamp;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.FragmentManager;
import android.widget.Toast;

import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;

import ro.androidiasi.codecamp.codecamperdetails.CodecamperDetailsFragment_;
import ro.androidiasi.codecamp.internal.model.Codecamper;
import ro.androidiasi.codecamp.internal.model.Session;
import ro.androidiasi.codecamp.main.MainActivity;
import ro.androidiasi.codecamp.sessiondetail.SessionDetailsActivity;

/**
 * Created by andrei on 06/04/16.
 */
@EBean
public class Navigator {

    @RootContext Context mContext;

    public void goToMainActivity() {
        MainActivity.start(mContext);
    }

    public void goToSessionDetails(Session pSession) {
        SessionDetailsActivity.start(mContext, pSession);
    }

    public void goToCodecamperDetails(FragmentManager pFragmentManager, Codecamper pCodecamper) {
        CodecamperDetailsFragment_.builder()
                .mCodecamper(pCodecamper)
                .build()
                .show(pFragmentManager, "dialog");
    }

    public void goToWebPage(String pUrl) {
        Uri webpage = Uri.parse(pUrl);
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
