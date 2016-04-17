package ro.androidiasi.codecamp.main;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import ro.androidiasi.codecamp.internal.IPresenter;
import ro.androidiasi.codecamp.internal.IView;

/**
 * Created by andrei on 16/04/16.
 */
public interface MainContract {

    interface View extends IView {

    }

    interface Presenter extends IPresenter {

        void setupViewPager(ViewPager pViewPager, TabLayout pTabLayout);

        void setupTabLayout(TabLayout pTabLayout, ViewPager pViewPager);
    }
}
