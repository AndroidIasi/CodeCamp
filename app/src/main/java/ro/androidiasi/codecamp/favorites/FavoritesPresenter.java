package ro.androidiasi.codecamp.favorites;

import org.androidannotations.annotations.EBean;

import java.util.List;

import ro.androidiasi.codecamp.data.model.DataSession;
import ro.androidiasi.codecamp.data.source.ILoadCallback;
import ro.androidiasi.codecamp.internal.model.Session;
import ro.androidiasi.codecamp.sessions.SessionsPresenter;

/**
 * Created by andrei on 22/04/16.
 */
@EBean
public class FavoritesPresenter extends SessionsPresenter implements FavoritesContract.Presenter{

    @Override public void refreshSessions() {
        this.refreshSessions(false);
    }

    @Override public void refreshSessions(boolean pForced) {
        this.mRepository.getFavoriteSessionsList(pForced, new ILoadCallback<List<DataSession>>() {
            @Override public void onSuccess(List<DataSession> pObject) {
                if(getView() != null && getView().isActive()){
                    getView().onSuccess(Session.fromDataSessionList(pObject));
                }
            }

            @Override public void onFailure(Exception pException) {
                if(getView() != null && getView().isActive()){
                    getView().onFailure();
                }
            }
        });
    }
}
