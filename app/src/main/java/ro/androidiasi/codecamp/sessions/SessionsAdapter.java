package ro.androidiasi.codecamp.sessions;

import android.content.Context;
import android.view.ViewGroup;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;

import ro.androidiasi.codecamp.internal.recycler.BaseRecyclerViewAdapter;
import ro.androidiasi.codecamp.internal.model.Session;
import ro.androidiasi.codecamp.sessions.item.SessionItemPresenter;
import ro.androidiasi.codecamp.sessions.item.SessionItemView;

/**
 * Created by andrei on 10/04/16.
 */
@EBean
public class SessionsAdapter extends BaseRecyclerViewAdapter<Session, SessionItemView, SessionItemPresenter> {

    @RootContext Context mContext;
    @Bean SessionItemPresenter mSessionItemPresenter;

    @Override protected SessionItemView getItemView(ViewGroup parent, int viewType) {
        return SessionItemView_.build(mContext);
    }

    @Override protected SessionItemPresenter getPresenter() {
        return mSessionItemPresenter;
    }

}
