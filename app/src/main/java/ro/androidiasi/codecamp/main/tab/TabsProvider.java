package ro.androidiasi.codecamp.main.tab;

import android.content.Context;
import android.support.v4.app.Fragment;

import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;

import java.util.ArrayList;
import java.util.List;

import ro.androidiasi.codecamp.R;
import ro.androidiasi.codecamp.about.AboutFragment;
import ro.androidiasi.codecamp.codecampers.CodecampersFragment;
import ro.androidiasi.codecamp.sessions.SessionsFragment;

/**
 * Created by andrei on 19/04/16.
 */
@EBean
public class TabsProvider {

    @RootContext Context mContext;

    private List<ITab> mTabsList = new ArrayList<>();

    @AfterInject public void afterMembersInject(){
        this.mTabsList.add(new ITab() {
            @Override public String getName() {
                return mContext.getString(R.string.tab_1_name);
            }

            @Override public Fragment getFragment() {
                return SessionsFragment.newInstance();
            }
        });
        this.mTabsList.add(new ITab() {
            @Override public String getName() {
                return mContext.getString(R.string.tab_2_name);
            }

            @Override public Fragment getFragment() {
                return SessionsFragment.newInstance(true);
            }
        });
        this.mTabsList.add(new ITab() {
            @Override public String getName() {
                return mContext.getString(R.string.tab_3_name);
            }

            @Override public Fragment getFragment() {
                return CodecampersFragment.newInstance();
            }
        });
        this.mTabsList.add(new ITab() {
            @Override public String getName() {
                return mContext.getString(R.string.tab_4_name);
            }

            @Override public Fragment getFragment() {
                return AboutFragment.newInstance();
            }
        });
    }

    public List<ITab> getTabsList() {
        return mTabsList;
    }
}