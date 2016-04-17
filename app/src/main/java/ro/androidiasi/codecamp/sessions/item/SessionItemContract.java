package ro.androidiasi.codecamp.sessions.item;

import ro.androidiasi.codecamp.internal.IView;
import ro.androidiasi.codecamp.internal.model.Session;
import ro.androidiasi.codecamp.internal.recycler.IRecyclerItemPresenter;

/**
 * Created by andrei on 16/04/16.
 */
public interface SessionItemContract {

    interface View extends IView {
        void setCodecamperPhotoUrl(String pPhotoUrl);
        void setDescription(String pDescriptionText);
        void setRoomName(String pRoomText);
    }

    interface Presenter extends IRecyclerItemPresenter<Session, SessionItemView> {

    }
}
