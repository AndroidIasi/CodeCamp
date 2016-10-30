package ro.androidiasi.codecamp.internal;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.widget.ImageView;

import com.bumptech.glide.request.target.BitmapImageViewTarget;

/**
 * Created by andrei.
 */

public class CircleBitmapImageViewTarget extends BitmapImageViewTarget {

    private final Context mContext;

    public CircleBitmapImageViewTarget(Context pContext, ImageView pImageView) {
        super(pImageView);
        mContext = pContext;
    }

    @Override
    protected void setResource(Bitmap resource) {
        RoundedBitmapDrawable circularBitmapDrawable =
                RoundedBitmapDrawableFactory.create(mContext.getResources(), resource);
        circularBitmapDrawable.setCircular(true);
        getView().setImageDrawable(circularBitmapDrawable);
    }
}
