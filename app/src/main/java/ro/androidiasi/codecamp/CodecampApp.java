package ro.androidiasi.codecamp;

import android.app.Application;

import com.crashlytics.android.Crashlytics;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.core.ImagePipelineConfig;

import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EApplication;

import io.fabric.sdk.android.Fabric;
import ro.androidiasi.codecamp.data.source.AgendaRepository;
import ro.androidiasi.codecamp.data.source.EventSource;
import ro.androidiasi.codecamp.data.source.IAgendaDataSource;

/**
 * Created by andrei on 08/04/16.
 */
@EApplication
public class CodecampApp extends Application {

    @Bean(AgendaRepository.class) IAgendaDataSource<Long> mRepository;
    private EventSource mEventSource;

    @Override public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
        Fabric.with(this, new Crashlytics());
    }

    @AfterInject public void afterMembersInject(){
        this.mEventSource = EventSource.CLUJ;
        this.mRepository.setEventSource(mEventSource);
    }

    public IAgendaDataSource<Long> getRepository() {
        return mRepository;
    }
}
