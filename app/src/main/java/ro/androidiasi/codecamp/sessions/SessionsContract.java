package ro.androidiasi.codecamp.sessions;

import android.widget.TextView;

import se.emilsjolander.stickylistheaders.StickyListHeadersListView;

/**
 * Created by andrei on 08/04/16.
 */
public interface SessionsContract {

    interface View{

        StickyListHeadersListView getListView();

        TextView getEmptyListTextView();
    }

    interface Presenter{

        void afterViews();

        void onEventSessionUpdated();
    }

}
