package ro.androidiasi.codecamp.codecampers;

import android.support.v4.widget.SwipeRefreshLayout;
import android.widget.ListView;

import ro.androidiasi.codecamp.internal.IPresenter;
import ro.androidiasi.codecamp.internal.IView;

/**
 * Created by andrei on 19/04/16.
 */
public interface CodecampersContract {

    interface View extends IView {

        boolean isAdded();

        ListView getListView();

        SwipeRefreshLayout getSwipeRefreshLayout();
    }

    interface Presenter extends IPresenter {

        void afterViews();
    }

}
