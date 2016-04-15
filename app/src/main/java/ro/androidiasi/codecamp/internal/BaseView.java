package ro.androidiasi.codecamp.internal;

/**
 * Created by andrei on 16/04/16.
 */
public interface BaseView<Presenter extends BasePresenter> {
    void setPresenter(Presenter pPresenter);
}
