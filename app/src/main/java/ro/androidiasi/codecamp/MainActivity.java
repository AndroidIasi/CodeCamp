package ro.androidiasi.codecamp;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.activity_main)
public class MainActivity extends BaseActivity {

    @ViewById(R.id.tab_layout) TabLayout mTabLayout;
    @ViewById(R.id.view_pager) ViewPager mViewPager;

    @Override public void afterViews() {
        super.afterViews();
        this.mTabLayout.addTab(mTabLayout.newTab().setText("Tab 1"));
        this.mTabLayout.addTab(mTabLayout.newTab().setText("Tab 2"));
        this.mTabLayout.addTab(mTabLayout.newTab().setText("Tab 3"));
        this.mTabLayout.addTab(mTabLayout.newTab().setText("Tab 4"));

        this.mViewPager.setAdapter(new MainPagerAdapter(getSupportFragmentManager()));

        this.mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTabLayout));
        this.mTabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override public void onTabSelected(TabLayout.Tab tab) {
                mViewPager.setCurrentItem(tab.getPosition());
            }

            @Override public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}
