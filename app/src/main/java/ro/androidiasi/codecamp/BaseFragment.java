package ro.androidiasi.codecamp;

import android.support.annotation.CallSuper;
import android.support.v4.app.Fragment;

import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EFragment;

import ro.androidiasi.codecamp.internal.aa.IEnhancedView;

/**
 * Created by andrei on 08/04/16.
 */
@EFragment
public abstract class BaseFragment extends Fragment implements IEnhancedView {

    @Bean public Navigator mNavigator;

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

    public Navigator getNavigator() {
        return mNavigator;
    }
}
