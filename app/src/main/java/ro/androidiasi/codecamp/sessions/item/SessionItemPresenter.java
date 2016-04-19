package ro.androidiasi.codecamp.sessions.item;

import android.net.Uri;

import org.androidannotations.annotations.EBean;

import ro.androidiasi.codecamp.internal.model.Session;

/**
 * Created by andrei on 10/04/16.
 */
@EBean
public class SessionItemPresenter implements SessionItemContract.Presenter<Session, SessionItemView> {

    @Override public void bind(Session pSession, SessionItemView pSessionItemView) {
        Uri photoUri = Uri.parse(pSession.getCodecampersList().get(0).getPhotoUrl());
        pSessionItemView.getDraweeView().setImageURI(photoUri);
        pSessionItemView.getNameTextView().setText(pSession.getName());
        String track = String.format("%s - Floor %s", pSession.getRoom().getName(), pSession.getRoom().getFloor());
        pSessionItemView.getTrackTextView().setText(track);
    }

}
