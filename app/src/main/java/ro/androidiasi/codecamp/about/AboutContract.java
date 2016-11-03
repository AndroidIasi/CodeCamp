package ro.androidiasi.codecamp.about;

import android.widget.TextView;

import ro.androidiasi.codecamp.internal.IPresenter;
import ro.androidiasi.codecamp.internal.IView;

/**
 * Created by andrei on 20/04/16.
 */
public interface AboutContract {

    interface View extends IView {
        TextView getVersionTextView();
    }

    interface Presenter extends IPresenter {
        void setView(View pView);

        void afterViews();

        void onThisAppIsOpenSourceClicked();
    }
}
