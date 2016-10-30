package ro.androidiasi.codecamp.codecampers.item;

import android.content.Context;
import android.net.Uri;

import com.bumptech.glide.Glide;

import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;

import ro.androidiasi.codecamp.R;
import ro.androidiasi.codecamp.internal.CircleBitmapImageViewTarget;
import ro.androidiasi.codecamp.internal.model.Codecamper;

/**
 * Created by andrei on 18/04/16.
 */
@EBean
public class CodecamperItemPresenter implements CodecamperItemContract.Presenter {

    @RootContext Context mContext;

    @Override public void bind(Codecamper pModel, final CodecamperItemView pView) {
        Uri uri = Uri.parse(pModel.getPhotoUrl());
        pView.getFullNameTextView().setText(pModel.getFullName());
        pView.getTitleTextView().setText(pModel.getTitle());
        pView.getCompanyTextView().setText(pModel.getCompany());
        Glide.with(mContext)
                .load(uri)
                .asBitmap()
                .centerCrop()
                .placeholder(R.drawable.codecamper)
                .into(new CircleBitmapImageViewTarget(mContext, pView.getPhotoDraweeView()));
    }

}
