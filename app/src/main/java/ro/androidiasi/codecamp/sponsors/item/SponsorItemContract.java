package ro.androidiasi.codecamp.sponsors.item;

import ro.androidiasi.codecamp.internal.IView;
import ro.androidiasi.codecamp.internal.model.IModel;
import ro.androidiasi.codecamp.internal.recycler.IListViewItemPresenter;

/**
 * Created by andrei.
 */

public interface SponsorItemContract {
    interface View extends IView {
        void loadLogo(String pLogoUrl);
    }

    interface Presenter<TModel extends IModel, TView extends android.view.View & View>
            extends IListViewItemPresenter<TModel, TView> {

    }
}
