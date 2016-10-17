package ro.androidiasi.codecamp.sponsors.item;

import org.androidannotations.annotations.EBean;

import ro.androidiasi.codecamp.internal.model.Sponsor;

/**
 * Created by andrei.
 */
@EBean
public class SponsorItemPresenter implements SponsorItemContract.Presenter<Sponsor, SponsorItemView>{
    @Override public void bind(Sponsor pModel, SponsorItemView pView) {
        pView.loadLogo(pModel.getLogoUrl());
    }
}
