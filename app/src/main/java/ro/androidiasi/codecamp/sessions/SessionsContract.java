package ro.androidiasi.codecamp.sessions;

import android.support.v4.widget.SwipeRefreshLayout;
import android.widget.TextView;

import ro.androidiasi.codecamp.data.source.IAgendaDataSource;
import se.emilsjolander.stickylistheaders.StickyListHeadersListView;

/**
 * Created by andrei on 08/04/16.
 */
public interface SessionsContract {

    interface View{

        StickyListHeadersListView getListView();

        TextView getEmptyListTextView();

        SwipeRefreshLayout getSwipeRefreshLayout();
    }

    interface Presenter{

        void afterViews();

        void onEventSessionUpdated();

        void setRepository(IAgendaDataSource<Long> pRepository);

        void setView(View pView);
    }

}
