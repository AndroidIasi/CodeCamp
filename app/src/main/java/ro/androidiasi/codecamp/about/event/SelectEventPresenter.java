package ro.androidiasi.codecamp.about.event;

import org.androidannotations.annotations.EBean;

import ro.androidiasi.codecamp.internal.model.Conference;

/**
 * Created by andrei on 05/05/16.
 */
@EBean
public class SelectEventPresenter implements SelectEventContract.Presenter {

    @Override public void bind(Conference pModel, SelectEventView pView) {
        pView.setName(pModel.getName());
    }
}
