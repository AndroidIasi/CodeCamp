package ro.androidiasi.codecamp.internal.recycler;

import ro.androidiasi.codecamp.internal.IPresenter;
import ro.androidiasi.codecamp.internal.model.IModel;

/**
 * Created by andrei on 10/04/16.
 */
public interface IRecyclerItemPresenter<Model extends IModel, View extends android.view.View> extends IPresenter {
    void bind(Model pModel, View pView);
}
