package ro.androidiasi.codecamp.sessions.header;

import android.widget.TextView;

import ro.androidiasi.codecamp.internal.IView;
import ro.androidiasi.codecamp.internal.model.Session;
import ro.androidiasi.codecamp.internal.recycler.IListViewItemPresenter;

/**
 * Created by andrei on 18/04/16.
 */
public class SessionHeaderContract {

    public interface View extends IView{
        TextView getTimeTextView();
    }

    public interface Presenter extends IListViewItemPresenter<Session, SessionHeaderView> {

    }
}
