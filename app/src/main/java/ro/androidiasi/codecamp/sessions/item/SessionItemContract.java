package ro.androidiasi.codecamp.sessions.item;

import ro.androidiasi.codecamp.internal.BaseView;
import ro.androidiasi.codecamp.internal.model.Session;
import ro.androidiasi.codecamp.internal.recycler.IRecyclerItemPresenter;

/**
 * Created by andrei on 16/04/16.
 */
public class SessionItemContract {

    public interface View extends BaseView<Presenter> {
        void setCodecamperPhotoUrl(String pPhotoUrl);
        void setDescription(String pDescriptionText);
        void setRoomName(String pRoomText);
    }

    public interface Presenter extends IRecyclerItemPresenter<Session, SessionItemView> {

    }
}
