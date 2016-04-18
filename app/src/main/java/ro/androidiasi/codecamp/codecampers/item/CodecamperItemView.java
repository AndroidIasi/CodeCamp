package ro.androidiasi.codecamp.codecampers.item;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

import ro.androidiasi.codecamp.R;

/**
 * Created by andrei on 18/04/16.
 */
@EViewGroup(R.layout.item_codecamper)
public class CodecamperItemView extends LinearLayout implements CodecamperItemContract.View {

    @ViewById(R.id.photo) SimpleDraweeView mPhotoDraweeView;
    @ViewById(R.id.full_name) TextView mFullNameTextView;
    @ViewById(R.id.title) TextView mTitleTextView;
    @ViewById(R.id.company) TextView mCompanyTextView;

    public CodecamperItemView(Context context) {
        super(context);
    }

    public CodecamperItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }


    @Override public SimpleDraweeView getPhotoDraweeView() {
        return mPhotoDraweeView;
    }

    @Override public TextView getFullNameTextView() {
        return mFullNameTextView;
    }

    @Override public TextView getTitleTextView() {
        return mTitleTextView;
    }

    @Override public TextView getCompanyTextView() {
        return mCompanyTextView;
    }
}
