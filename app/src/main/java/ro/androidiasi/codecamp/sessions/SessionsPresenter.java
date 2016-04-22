package ro.androidiasi.codecamp.sessions;

import android.support.v4.widget.SwipeRefreshLayout;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EBean;

import java.util.List;

import ro.androidiasi.codecamp.R;
import ro.androidiasi.codecamp.data.model.DataSession;
import ro.androidiasi.codecamp.data.source.IAgendaDataSource;
import ro.androidiasi.codecamp.data.source.ILoadCallback;
import ro.androidiasi.codecamp.internal.model.Session;

/**
 * Created by andrei on 08/04/16.
 */
@EBean
public class SessionsPresenter implements SessionsContract.Presenter, SwipeRefreshLayout.OnRefreshListener {

    @Bean public SessionsAdapter mSessionsAdapter;

    protected IAgendaDataSource<Long> mRepository;
    protected SessionsContract.View mView;

    @Override public void afterViews() {
        if(mView == null){
            throw new NullPointerException("View is NULL! Please set the view first!");
        }
        if(mRepository == null){
            throw new NullPointerException("Repository is NULL! Please set the Repository first!");
        }
        this.mView.getListView().setAdapter(this.mSessionsAdapter);
        this.mView.getSwipeRefreshLayout().setColorSchemeResources(
                R.color.holo_blue_bright,
                R.color.holo_green_light,
                R.color.holo_orange_light,
                R.color.holo_red_light);
        this.mView.getSwipeRefreshLayout().setOnRefreshListener(this);
        this.updateAdapter();
    }

    @Override public void onEventSessionUpdated() {
        this.updateAdapter();
    }

    protected void updateAdapter() {
        this.mRepository.getSessionsList(new ILoadCallback<List<DataSession>>() {
            @Override public void onSuccess(List<DataSession> pObject) {
                mSessionsAdapter.update(Session.fromDataSessionList(pObject));
            }

            @Override public void onFailure(Exception pE) {

            }
        });
    }

    public void setView(SessionsContract.View pView) {
        mView = pView;
    }

    public void setRepository(IAgendaDataSource<Long> pRepository) {
        mRepository = pRepository;
    }

    @Override public void onRefresh() {
        this.mRepository.getSessionsList(true, new ILoadCallback<List<DataSession>>() {
            @Override public void onSuccess(List<DataSession> pObject) {
                mSessionsAdapter.update(Session.fromDataSessionList(pObject));
                if(mView.isAdded()) {
                    mView.getSwipeRefreshLayout().setRefreshing(false);
                }
            }

            @Override public void onFailure(Exception pException) {
                if(mView.isAdded()) {
                    mView.getSwipeRefreshLayout().setRefreshing(false);
                }
            }
        });
    }
}
