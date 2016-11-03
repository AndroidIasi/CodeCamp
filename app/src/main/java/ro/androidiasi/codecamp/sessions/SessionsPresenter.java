package ro.androidiasi.codecamp.sessions;

import org.androidannotations.annotations.EBean;

import java.util.List;

import ro.androidiasi.codecamp.data.model.DataSession;
import ro.androidiasi.codecamp.data.source.IAgendaDataSource;
import ro.androidiasi.codecamp.data.source.ILoadCallback;
import ro.androidiasi.codecamp.internal.model.Session;

/**
 * Created by andrei on 08/04/16.
 */
@EBean
public class SessionsPresenter implements SessionsContract.Presenter {

    protected IAgendaDataSource<Long> mRepository;
    protected SessionsContract.View mView;

    @Override public void start() {
        if (mView == null) {
            throw new NullPointerException("View is NULL! Please set the view first!");
        }
        if (mRepository == null) {
            throw new NullPointerException("Repository is NULL! Please set the Repository first!");
        }
        refreshSessions();
    }

    public void refreshSessions() {
        this.mRepository.getSessionsList(new ILoadCallback<List<DataSession>>() {
            @Override public void onSuccess(List<DataSession> pObject) {
                if (getView() != null) {
                    getView().onSuccess(Session.fromDataSessionList(pObject));
                }
            }

            @Override public void onFailure(Exception pException) {
                if (getView() != null) {
                    getView().onFailure();
                }
            }
        });
    }

    @Override public void setView(SessionsContract.View pView) {
        mView = pView;
    }

    @Override public SessionsContract.View getView() {
        return mView;
    }

    @Override public void refreshSessions(boolean pForced) {
        getView().onLoad();
        this.mRepository.getSessionsList(pForced, new ILoadCallback<List<DataSession>>() {
            @Override public void onSuccess(List<DataSession> pObject) {
                if (getView() != null) {
                    getView().onSuccess(Session.fromDataSessionList(pObject));
                }
            }

            @Override public void onFailure(Exception pException) {
                if (getView() != null) {
                    getView().onFailure();
                }
            }
        });
    }


    @Override public void setRepository(IAgendaDataSource<Long> pRepository) {
        mRepository = pRepository;
    }
}
