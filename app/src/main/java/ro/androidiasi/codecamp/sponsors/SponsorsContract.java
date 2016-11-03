package ro.androidiasi.codecamp.sponsors;

import java.util.List;

import ro.androidiasi.codecamp.data.source.IAgendaDataSource;
import ro.androidiasi.codecamp.internal.IPresenter;
import ro.androidiasi.codecamp.internal.IView;
import ro.androidiasi.codecamp.internal.model.Sponsor;

/**
 * Created by andrei.
 */

public interface SponsorsContract {
    interface View extends IView {

        void updateSponsors(List<Sponsor> pResult);

        void onFailure();
    }

    interface Presenter extends IPresenter {
        void start();

        void setRepository(IAgendaDataSource<Long> pRepository);
        void setView(View pView);
        View getView();

        void refreshSponsors(boolean pForced);
    }
}
