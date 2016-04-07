package ro.androidiasi.codecamp;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import ro.androidiasi.codecamp.sessions.SessionsFragment;

/**
 * Created by andrei on 08/04/16.
 */

public class MainPagerAdapter extends FragmentStatePagerAdapter {

    public MainPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override public Fragment getItem(int position) {
        return SessionsFragment.newInstance();
    }

    @Override public int getCount() {
        return 4;
    }
}
