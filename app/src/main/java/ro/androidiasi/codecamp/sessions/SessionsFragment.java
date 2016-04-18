package ro.androidiasi.codecamp.sessions;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import ro.androidiasi.codecamp.BaseFragment;
import ro.androidiasi.codecamp.R;
import se.emilsjolander.stickylistheaders.StickyListHeadersListView;

/**
 * Created by andrei on 08/04/16.
 */
@EFragment(R.layout.fragment_sessions_list)
public class SessionsFragment extends BaseFragment implements SessionsContract.View {

    @Bean SessionsPresenter mSessionsPresenter;
    @ViewById(R.id.list_view) StickyListHeadersListView mListView;

    public static SessionsFragment newInstance(){
        return SessionsFragment_.builder()
                .build();
    }

    @Override public void afterViews() {
        super.afterViews();
        this.mSessionsPresenter.setView(this);
        this.mSessionsPresenter.afterViews();
    }

    @Override public StickyListHeadersListView getListView() {
        return this.mListView;
    }
}
