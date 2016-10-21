package ro.androidiasi.codecamp.sessions;

import java.util.List;

import ro.androidiasi.codecamp.data.source.IAgendaDataSource;
import ro.androidiasi.codecamp.internal.IPresenter;
import ro.androidiasi.codecamp.internal.IView;
import ro.androidiasi.codecamp.internal.model.Session;

/**
 * Created by andrei on 08/04/16.
 */
public interface SessionsContract {

    interface View extends IView{

        boolean isActive();
        void onLoad();
        void onSuccess(List<Session> pSessionList);
        void onFailure();
    }

    interface Presenter extends IPresenter{

        void start();

        void setRepository(IAgendaDataSource<Long> pRepository);

        void setView(View pView);

        View getView();

        void refreshSessions(boolean pForced);
    }

}
