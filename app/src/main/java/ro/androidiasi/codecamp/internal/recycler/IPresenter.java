package ro.androidiasi.codecamp.internal.recycler;

import ro.androidiasi.codecamp.internal.model.IModel;

/**
 * Created by andrei on 10/04/16.
 */
public interface IPresenter<Model extends IModel, View extends android.view.View> {
    void bind(Model pModel, View pView);
}
