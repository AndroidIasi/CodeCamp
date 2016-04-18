package ro.androidiasi.codecamp.sessions.header;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import org.androidannotations.annotations.EViewGroup;

import java.util.Date;

import ro.androidiasi.codecamp.R;

/**
 * Created by andrei on 18/04/16.
 */
@EViewGroup(R.layout.item_session_header)
public class SessionHeaderView extends LinearLayout implements SessionHeaderContract.View{
    public SessionHeaderView(Context context) {
        super(context);
    }

    public SessionHeaderView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override public void setStartingTime(Date pStartingTime) {

    }

    @Override public void setEndingTime(Date pEndingTime) {

    }
}
