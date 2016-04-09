package ro.androidiasi.codecamp.sessions;

import ro.androidiasi.codecamp.internal.model.Session;

/**
 * Created by andrei on 08/04/16.
 */
public interface SessionsContract {

    interface View{

    }

    interface Presenter{

    }

    interface ItemPresenter {
        void bind(Session pSession, SessionItemView pSessionItemView);
    }
}
