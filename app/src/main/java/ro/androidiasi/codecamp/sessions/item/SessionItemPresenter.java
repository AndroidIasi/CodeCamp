package ro.androidiasi.codecamp.sessions.item;

import org.androidannotations.annotations.EBean;

import ro.androidiasi.codecamp.internal.model.Session;

/**
 * Created by andrei on 10/04/16.
 */
@EBean
public class SessionItemPresenter implements SessionItemContract.Presenter<Session, SessionItemView> {

    @Override public void bind(Session pSession, SessionItemView pSessionItemView) {
        pSessionItemView.setCodecamperPhotoUrl(pSession.getCodecampersList().get(0).getPhotoUrl());
        pSessionItemView.setName(pSession.getName());
        pSessionItemView.setRoomName(pSession.getRoom().getName());
    }

}
