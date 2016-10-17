package ro.androidiasi.codecamp.sponsors.header;

import org.androidannotations.annotations.EBean;

import ro.androidiasi.codecamp.internal.model.Sponsor;

/**
 * Created by andrei.
 */
@EBean
public class SponsorHeaderPresenter implements SponsorHeaderContract.Presenter {
    @Override public void bind(Sponsor pSponsor, SponsorHeaderContract.View pSponsorHeaderView) {
        pSponsorHeaderView.setText(pSponsor.getSponsorshipPackage());
    }
}
