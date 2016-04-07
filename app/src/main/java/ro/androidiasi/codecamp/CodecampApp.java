package ro.androidiasi.codecamp;

import android.app.Application;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EApplication;

/**
 * Created by andrei on 08/04/16.
 */
@EApplication
public class CodecampApp extends Application {

    @Bean Navigator mNavigator;

    @Override public void onCreate() {
        super.onCreate();
    }
}
