package ro.androidiasi.codecamp.sessions;

import se.emilsjolander.stickylistheaders.StickyListHeadersListView;

/**
 * Created by andrei on 08/04/16.
 */
public interface SessionsContract {

    interface View{

        StickyListHeadersListView getListView();
    }

    interface Presenter{

        void afterViews();

        void onEventSessionUpdated();
    }

}
