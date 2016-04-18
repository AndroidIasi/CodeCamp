package ro.androidiasi.codecamp.codecampers.item;

import android.net.Uri;

import org.androidannotations.annotations.EBean;

import ro.androidiasi.codecamp.internal.model.Codecamper;

/**
 * Created by andrei on 18/04/16.
 */
@EBean
public class CodecamperItemPresenter implements CodecamperItemContract.Presenter {

    @Override public void bind(Codecamper pModel, CodecamperItemView pView) {
        Uri uri = Uri.parse(pModel.getPhotoUrl());
        pView.getPhotoDraweeView().setImageURI(uri);
        pView.getFullNameTextView().setText(pModel.getFullName());
        pView.getTitleTextView().setText(pModel.getTitle());
        pView.getCompanyTextView().setText(pModel.getCompany());
    }
}
