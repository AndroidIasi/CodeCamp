package ro.androidiasi.codecamp.codecampers;

import android.widget.ListView;

import ro.androidiasi.codecamp.internal.IPresenter;
import ro.androidiasi.codecamp.internal.IView;

/**
 * Created by andrei on 19/04/16.
 */
public interface CodecampersContract {

    interface View extends IView{

        ListView getListView();
    }

    interface Presenter extends IPresenter{

        void afterViews();
    }

}
