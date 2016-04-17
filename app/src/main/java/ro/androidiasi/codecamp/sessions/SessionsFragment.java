package ro.androidiasi.codecamp.sessions;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import ro.androidiasi.codecamp.BaseFragment;
import ro.androidiasi.codecamp.R;

/**
 * Created by andrei on 08/04/16.
 */
@EFragment(R.layout.fragment_sessions_list)
public class SessionsFragment extends BaseFragment implements SessionsContract.View {

    @Bean SessionsPresenter mSessionsPresenter;
    @ViewById(R.id.recycler) RecyclerView mRecyclerView;

    public static SessionsFragment newInstance(){
        return SessionsFragment_.builder()
                .build();
    }

    @Override public void afterViews() {
        super.afterViews();
        this.mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        this.mSessionsPresenter.setView(this);
        this.mSessionsPresenter.afterViews();
    }

    @Override public RecyclerView getRecyclerView() {
        return this.mRecyclerView;
    }
}
