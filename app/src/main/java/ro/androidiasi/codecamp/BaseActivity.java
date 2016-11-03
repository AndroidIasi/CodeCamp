package ro.androidiasi.codecamp;

import android.support.annotation.CallSuper;
import android.support.v7.app.AppCompatActivity;

import org.androidannotations.annotations.AfterExtras;
import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.App;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EActivity;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import ro.androidiasi.codecamp.data.source.IAgendaDataSource;
import ro.androidiasi.codecamp.internal.aa.IEnhancedActivity;
import ro.androidiasi.codecamp.internal.bus.CodecampBus;

/**
 * Created by andrei on 08/04/16.
 */
@EActivity
public abstract class BaseActivity extends AppCompatActivity implements IEnhancedActivity {

    @App  public CodecampApp mCodecampApp;
    @Bean public Navigator mNavigator;
    @Bean public CodecampBus mCodecampBus;

    @AfterExtras
    @Override public final void afterExtrasInject() {
        this.afterExtras();
    }

    @AfterInject
    @Override public final void afterMembersInject() {
        this.afterInject();
    }

    @AfterViews
    @Override public final void afterViewsInject() {
        this.afterViews();
    }

    @CallSuper
    @Override public void afterExtras() {
        //empty
    }

    @CallSuper
    @Override public void afterInject() {
        //empty
    }

    @CallSuper
    @Override public void afterViews() {
        //empty
    }

    @Override protected void onResume() {
        super.onResume();
        this.mCodecampBus.register(this);
    }

    @Override protected void onPause() {
        super.onPause();
        this.mCodecampBus.unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void onEventMainThread(Object pObject) { }

    public Navigator getNavigator() {
        return mNavigator;
    }

    public IAgendaDataSource<Long> getRepository() {
        return this.mCodecampApp.getRepository();
    }

    public CodecampBus getCodecampBus() {
        return mCodecampBus;
    }
}
