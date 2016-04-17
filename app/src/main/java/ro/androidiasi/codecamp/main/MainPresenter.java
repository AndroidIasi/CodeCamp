package ro.androidiasi.codecamp.main;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;

import ro.androidiasi.codecamp.R;

/**
 * Created by andrei on 16/04/16.
 */
@EBean
public class MainPresenter implements MainContract.Presenter {

    @RootContext MainActivity mMainActivity;

    private MainPagerAdapter mMainPagerAdapter;

    @AfterInject public void afterMembersInject(){
        this.mMainPagerAdapter = new MainPagerAdapter(mMainActivity.getSupportFragmentManager());
    }

    public void afterViews() {
        final TabLayout pTabLayout = mMainActivity.getTabLayout();
        final ViewPager pViewPager = mMainActivity.getViewPager();
        this.setupTabLayout(pTabLayout, pViewPager);
        this.setupViewPager(pViewPager, pTabLayout);
    }

    @Override public void setupViewPager(ViewPager pViewPager, TabLayout pTabLayout){
        pViewPager.setAdapter(mMainPagerAdapter);
        pViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(pTabLayout));
    }

    @Override public void setupTabLayout(TabLayout pTabLayout,final ViewPager pViewPager){
        pTabLayout.addTab(pTabLayout.newTab().setText(R.string.tab_1_name));
        pTabLayout.addTab(pTabLayout.newTab().setText(R.string.tab_2_name));
        pTabLayout.addTab(pTabLayout.newTab().setText(R.string.tab_3_name));
        pTabLayout.addTab(pTabLayout.newTab().setText(R.string.tab_4_name));
        pTabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override public void onTabSelected(TabLayout.Tab tab) {
                pViewPager.setCurrentItem(tab.getPosition());
            }

            @Override public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}
