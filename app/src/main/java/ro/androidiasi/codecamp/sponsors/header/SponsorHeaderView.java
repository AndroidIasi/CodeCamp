package ro.androidiasi.codecamp.sponsors.header;

import android.content.Context;
import android.util.AttributeSet;

import org.androidannotations.annotations.EViewGroup;

import ro.androidiasi.codecamp.R;
import ro.androidiasi.codecamp.sessions.header.SessionHeaderView;

/**
 * Created by andrei.
 */
@EViewGroup(R.layout.item_session_header)
public class SponsorHeaderView extends SessionHeaderView implements SponsorHeaderContract.View {

    public SponsorHeaderView(Context context) {
        super(context);
    }

    public SponsorHeaderView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override public void setText(String pText) {
        this.getTimeTextView().setText(pText);
    }
}
