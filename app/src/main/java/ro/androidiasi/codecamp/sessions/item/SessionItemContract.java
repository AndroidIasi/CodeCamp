package ro.androidiasi.codecamp.sessions.item;

import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import ro.androidiasi.codecamp.internal.IView;
import ro.androidiasi.codecamp.internal.model.IModel;
import ro.androidiasi.codecamp.internal.recycler.IListViewItemPresenter;

/**
 * Created by andrei on 16/04/16.
 */
public interface SessionItemContract {

    interface View extends IView {
        SimpleDraweeView getDraweeView();
        TextView getNameTextView();
        TextView getTrackTextView();
    }

    interface Presenter<TModel extends IModel, TView extends android.view.View & View>
            extends IListViewItemPresenter<TModel, TView> {

    }
}
