package ro.androidiasi.codecamp.about;

import android.content.Context;
import android.view.ViewGroup;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;

import ro.androidiasi.codecamp.about.event.SelectEventPresenter;
import ro.androidiasi.codecamp.about.event.SelectEventView;
import ro.androidiasi.codecamp.about.event.SelectEventView_;
import ro.androidiasi.codecamp.internal.model.Conference;
import ro.androidiasi.codecamp.internal.recycler.BaseListViewAdapter;

/**
 * Created by andrei on 05/05/16.
 */
@EBean
public class SelectEventAdapter extends BaseListViewAdapter<Conference, SelectEventView, SelectEventPresenter>{

    @Bean SelectEventPresenter mSelectEventPresenter;
    @RootContext Context mContext;

    @Override protected SelectEventView getItemView(ViewGroup parent) {
        return SelectEventView_.build(mContext);
    }

    @Override protected SelectEventPresenter getPresenter() {
        return mSelectEventPresenter;
    }
}
