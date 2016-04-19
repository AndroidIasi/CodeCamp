package ro.androidiasi.codecamp.sessions;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;

import ro.androidiasi.codecamp.internal.model.Session;
import ro.androidiasi.codecamp.internal.recycler.BaseListViewAdapter;
import ro.androidiasi.codecamp.sessions.header.SessionHeaderPresenter;
import ro.androidiasi.codecamp.sessions.header.SessionHeaderView;
import ro.androidiasi.codecamp.sessions.header.SessionHeaderView_;
import ro.androidiasi.codecamp.sessions.item.SessionItemPresenter;
import ro.androidiasi.codecamp.sessions.item.SessionItemView;
import ro.androidiasi.codecamp.sessions.item.SessionItemView_;
import se.emilsjolander.stickylistheaders.StickyListHeadersAdapter;

/**
 * Created by andrei on 10/04/16.
 */
@EBean
public class SessionsAdapter extends BaseListViewAdapter<Session, SessionItemView, SessionItemPresenter>
        implements StickyListHeadersAdapter {

    @RootContext Context mContext;
    @Bean SessionItemPresenter mSessionItemPresenter;
    @Bean SessionHeaderPresenter mSessionHeaderPresenter;

    @Override protected SessionItemView getItemView(ViewGroup parent) {
        return SessionItemView_.build(mContext);
    }

    @Override protected SessionItemPresenter getPresenter() {
        return mSessionItemPresenter;
    }

    @Override public View getHeaderView(int position, View convertView, ViewGroup parent) {
        SessionHeaderView view = (SessionHeaderView) convertView;
        if(view == null){
            view = SessionHeaderView_.build(mContext);
        }
        this.mSessionHeaderPresenter.bind(getItem(position), view);
        return view;
    }

    @Override public long getHeaderId(int position) {
        return getItem(position).getTimeFrame().getId();
    }

}