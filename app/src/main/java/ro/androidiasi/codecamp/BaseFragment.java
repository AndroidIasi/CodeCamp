package ro.androidiasi.codecamp;

import android.support.annotation.CallSuper;
import android.support.v4.app.Fragment;

import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EFragment;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import ro.androidiasi.codecamp.data.DummyRepository;
import ro.androidiasi.codecamp.data.source.IAgendaDataSource;
import ro.androidiasi.codecamp.internal.aa.IEnhancedView;
import ro.androidiasi.codecamp.internal.bus.CodecampBus;

/**
 * Created by andrei on 08/04/16.
 */
@EFragment
public abstract class BaseFragment extends Fragment implements IEnhancedView {

    @Bean public Navigator mNavigator;
    @Bean(DummyRepository.class) public IAgendaDataSource<Long> mRepository;
    @Bean public CodecampBus mCodecampBus;

    @AfterInject
    @Override public final void afterMembersInject(){
        this.afterInject();
    }

    @AfterViews
    @Override public final void afterViewsInject(){
        this.afterViews();
    }

    @CallSuper
    @Override public void afterInject(){
        //empty
    }

    @CallSuper
    @Override public void afterViews(){
        //empty
    }

    @Override public void onStart() {
        super.onStart();
        this.mCodecampBus.register(this);
    }

    @Override public void onStop() {
        super.onStop();
        this.mCodecampBus.unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true) public void onEventMainThread(Object pObject){}

    public Navigator getNavigator() {
        return mNavigator;
    }
    public IAgendaDataSource<Long> getRepository(){
        return mRepository;
    }
}
