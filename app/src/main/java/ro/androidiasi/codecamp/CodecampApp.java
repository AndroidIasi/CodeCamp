package ro.androidiasi.codecamp;

import android.app.Application;
import android.content.Context;

import com.facebook.drawee.backends.pipeline.Fresco;

import org.androidannotations.annotations.EApplication;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

/**
 * Created by andrei on 08/04/16.
 */
@EApplication
public class CodecampApp extends Application {

    @Override public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
        CalligraphyConfig config = new CalligraphyConfig.Builder()
                .setDefaultFontPath("font/Roboto-Regular.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build();
        CalligraphyConfig.initDefault(config);
    }

    @Override protected void attachBaseContext(Context base) {
        Context newBase = CalligraphyContextWrapper.wrap(base);
        super.attachBaseContext(newBase);
    }
}
