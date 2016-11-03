package ro.androidiasi.codecamp.about.event;

import ro.androidiasi.codecamp.internal.IView;
import ro.androidiasi.codecamp.internal.model.Conference;
import ro.androidiasi.codecamp.internal.recycler.IListViewItemPresenter;

/**
 * Created by andrei on 05/05/16.
 */
public interface SelectEventContract {
    interface View extends IView {
        void setName(String pName);
    }
    interface Presenter extends IListViewItemPresenter<Conference, SelectEventView> {

    }
}
