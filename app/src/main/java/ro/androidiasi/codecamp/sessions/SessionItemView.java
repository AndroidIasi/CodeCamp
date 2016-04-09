package ro.androidiasi.codecamp.sessions;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import org.androidannotations.annotations.EViewGroup;

/**
 * Created by andrei on 10/04/16.
 */
@EViewGroup
public class SessionItemView extends LinearLayout {

    public SessionItemView(Context context) {
        super(context);
    }

    public SessionItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

}
