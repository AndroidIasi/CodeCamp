package ro.androidiasi.codecamp.main;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

import ro.androidiasi.codecamp.main.tab.IMainTab;

/**
 * Created by andrei on 08/04/16.
 */

public class MainPagerAdapter extends FragmentStatePagerAdapter {

    private List<IMainTab> mTabs;

    public MainPagerAdapter(FragmentManager fm, List<IMainTab> pTabs) {
        super(fm);
        this.mTabs = pTabs;
    }

    @Override public Fragment getItem(int position) {
        return this.mTabs.get(position).getFragment();
    }

    @Override public int getCount() {
        return mTabs.size();
    }
}
