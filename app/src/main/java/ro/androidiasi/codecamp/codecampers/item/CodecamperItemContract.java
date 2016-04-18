package ro.androidiasi.codecamp.codecampers.item;

import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import ro.androidiasi.codecamp.internal.IView;
import ro.androidiasi.codecamp.internal.model.Codecamper;
import ro.androidiasi.codecamp.internal.recycler.IListViewItemPresenter;

/**
 * Created by andrei on 18/04/16.
 */
public interface CodecamperItemContract {
    interface View extends IView{

        SimpleDraweeView getPhotoDraweeView();

        TextView getFullNameTextView();

        TextView getTitleTextView();

        TextView getCompanyTextView();
    }
    interface Presenter extends IListViewItemPresenter<Codecamper, CodecamperItemView>{

    }
}
