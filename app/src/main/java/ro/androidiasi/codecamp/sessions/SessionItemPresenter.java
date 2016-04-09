package ro.androidiasi.codecamp.sessions;

import org.androidannotations.annotations.EBean;

import ro.androidiasi.codecamp.internal.recycler.IPresenter;
import ro.androidiasi.codecamp.internal.model.Session;

/**
 * Created by andrei on 10/04/16.
 */
@EBean
public class SessionItemPresenter implements IPresenter<Session, SessionItemView> {

    @Override public void bind(Session pSession, SessionItemView pSessionItemView) {
        //TODO
    }

}
