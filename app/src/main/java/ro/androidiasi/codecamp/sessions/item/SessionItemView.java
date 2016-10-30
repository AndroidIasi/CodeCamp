package ro.androidiasi.codecamp.sessions.item;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

import ro.androidiasi.codecamp.R;

/**
 * Created by andrei on 10/04/16.
 */
@EViewGroup(R.layout.item_session)
public class SessionItemView extends LinearLayout implements SessionItemContract.View {

    @ViewById(R.id.drawee_view) ImageView mDraweeView;
    @ViewById(R.id.name) TextView mNameTextView;
    @ViewById(R.id.track)       TextView mTrackTextView;

    public SessionItemView(Context context) {
        super(context);
    }

    public SessionItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override public ImageView getDraweeView() {
        return mDraweeView;
    }

    @Override public TextView getNameTextView() {
        return mNameTextView;
    }

    @Override public TextView getTrackTextView() {
        return mTrackTextView;
    }
}
