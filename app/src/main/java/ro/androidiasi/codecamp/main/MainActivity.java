package ro.androidiasi.codecamp.main;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import ro.androidiasi.codecamp.BaseActivity;
import ro.androidiasi.codecamp.R;

@EActivity(R.layout.activity_main)
public class MainActivity extends BaseActivity implements MainContract.View{

    @ViewById(R.id.tab_layout) TabLayout mTabLayout;
    @ViewById(R.id.view_pager) ViewPager mViewPager;

    @Bean MainPresenter mMainPresenter;

    @Override public void afterViews() {
        super.afterViews();
        this.mMainPresenter.afterViews();
    }

    public TabLayout getTabLayout() {
        return mTabLayout;
    }

    public ViewPager getViewPager() {
        return mViewPager;
    }
}
