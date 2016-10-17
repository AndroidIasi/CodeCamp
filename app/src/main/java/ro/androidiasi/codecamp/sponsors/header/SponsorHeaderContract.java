package ro.androidiasi.codecamp.sponsors.header;

import ro.androidiasi.codecamp.internal.IPresenter;
import ro.androidiasi.codecamp.internal.IView;
import ro.androidiasi.codecamp.internal.model.Sponsor;

/**
 * Created by andrei.
 */

public interface SponsorHeaderContract {
    interface View extends IView{
        void setText(String pText);
    }

    interface Presenter extends IPresenter{
        void bind(Sponsor pSponsor, View pView);
    }
}
