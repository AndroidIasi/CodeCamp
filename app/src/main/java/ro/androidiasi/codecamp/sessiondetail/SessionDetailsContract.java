package ro.androidiasi.codecamp.sessiondetail;

import ro.androidiasi.codecamp.internal.IPresenter;
import ro.androidiasi.codecamp.internal.IView;
import ro.androidiasi.codecamp.internal.model.Session;

/**
 * Created by andrei on 18/04/16.
 */
public interface SessionDetailsContract {
    public interface View extends IView{

    }

    public interface Presenter extends IPresenter{

        void afterViews();

        void setSession(Session pSession);
    }
}
