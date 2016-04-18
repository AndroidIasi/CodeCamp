package ro.androidiasi.codecamp.sessions;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EBean;

import java.util.List;

import ro.androidiasi.codecamp.data.DummyRepository;
import ro.androidiasi.codecamp.data.model.DataSession;
import ro.androidiasi.codecamp.data.source.IAgendaDataSource;
import ro.androidiasi.codecamp.data.source.ILoadCallback;
import ro.androidiasi.codecamp.internal.model.Session;

/**
 * Created by andrei on 08/04/16.
 */
@EBean
public class SessionsPresenter implements SessionsContract.Presenter {

    @Bean SessionsAdapter mSessionsAdapter;
    @Bean(DummyRepository.class) IAgendaDataSource<Long> mRepository;

    private SessionsContract.View mView;

    public void afterViews() {
        this.mView.getListView().setAdapter(this.mSessionsAdapter);
        this.mRepository.getSessionsList(new ILoadCallback<List<DataSession>>() {
            @Override public void onSuccess(List<DataSession> pObject) {
                mSessionsAdapter.update(Session.fromDataSessionList(pObject));
            }

            @Override public void onFailure() {

            }
        });
    }

    public void setView(SessionsContract.View pView) {
        mView = pView;
    }
}
