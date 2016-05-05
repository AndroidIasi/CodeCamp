package ro.androidiasi.codecamp;

import android.app.Application;

import com.crashlytics.android.Crashlytics;
import com.facebook.drawee.backends.pipeline.Fresco;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EApplication;

import io.fabric.sdk.android.Fabric;
import ro.androidiasi.codecamp.data.source.AgendaRepository;
import ro.androidiasi.codecamp.data.source.IAgendaDataSource;

/**
 * Created by andrei on 08/04/16.
 */
@EApplication
public class CodecampApp extends Application {

    @Bean(AgendaRepository.class) IAgendaDataSource<Long> mRepository;

    @Override public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
        Fabric.with(this, new Crashlytics());
    }

    public IAgendaDataSource<Long> getRepository() {
        return mRepository;
    }

}
