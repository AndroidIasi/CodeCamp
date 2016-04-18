package ro.androidiasi.codecamp.main;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;

import ro.androidiasi.codecamp.main.tab.TabsProvider;

/**
 * Created by andrei on 16/04/16.
 */
@EBean
public class MainPresenter implements MainContract.Presenter {

    @Bean TabsProvider mTabsProvider;
    @RootContext MainActivity mMainActivity;

    private MainPagerAdapter mMainPagerAdapter;

    @AfterInject public void afterMembersInject(){
        this.mMainPagerAdapter = new MainPagerAdapter(mMainActivity.getSupportFragmentManager(), mTabsProvider.getTabsList());
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
        for (int i = 0; i < mTabsProvider.getTabsList().size(); i++) {
            pTabLayout.addTab(pTabLayout.newTab().setText(mTabsProvider.getTabsList().get(i).getName()));
        }
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
