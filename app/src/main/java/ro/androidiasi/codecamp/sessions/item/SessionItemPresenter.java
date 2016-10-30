package ro.androidiasi.codecamp.sessions.item;

import android.content.Context;
import android.net.Uri;
import android.view.View;

import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;

import ro.androidiasi.codecamp.R;
import ro.androidiasi.codecamp.internal.model.Session;

/**
 * Created by andrei on 10/04/16.
 */
@EBean
public class SessionItemPresenter implements SessionItemContract.Presenter<Session, SessionItemView> {

    @RootContext Context mContext;

    @Override public void bind(Session pSession, SessionItemView pSessionItemView) {
        if(pSession.getCodecampersList().size() > 0) {
            pSessionItemView.getDraweeView().setVisibility(View.VISIBLE);
            pSessionItemView.getTrackTextView().setVisibility(View.VISIBLE);
            Uri photoUri = Uri.parse(pSession.getCodecampersList().get(0).getPhotoUrl());
            pSessionItemView.getDraweeView().setImageURI(photoUri);
        } else {
            pSessionItemView.getDraweeView().setImageURI(Uri.EMPTY);
            pSessionItemView.getDraweeView().setVisibility(View.GONE);
            pSessionItemView.getTrackTextView().setVisibility(View.GONE);
        }
        pSessionItemView.getNameTextView().setText(pSession.getName());
        String track = mContext.getString(R.string.session_track_name_and_floor,
                pSession.getRoom().getName(),
                pSession.getRoom().getDescription());
        pSessionItemView.getTrackTextView().setText(track);
    }

}
