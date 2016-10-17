package ro.androidiasi.codecamp.sessions.header;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

import ro.androidiasi.codecamp.R;

/**
 * Created by andrei on 18/04/16.
 */
@EViewGroup(R.layout.item_session_header)
public class SessionHeaderView extends LinearLayout implements SessionHeaderContract.View{

    @ViewById(R.id.text_time) public TextView mTimeTextView;

    public SessionHeaderView(Context context) {
        super(context);
    }

    public SessionHeaderView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override public TextView getTimeTextView() {
        return mTimeTextView;
    }
}
