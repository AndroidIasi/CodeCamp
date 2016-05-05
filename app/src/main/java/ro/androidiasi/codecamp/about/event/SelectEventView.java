package ro.androidiasi.codecamp.about.event;

import android.content.Context;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

import ro.androidiasi.codecamp.R;

/**
 * Created by andrei on 05/05/16.
 */
@EViewGroup(R.layout.item_select_conference)
public class SelectEventView extends LinearLayout implements SelectEventContract.View {

    @ViewById(R.id.text_time) AppCompatTextView mTextView;

    public SelectEventView(Context context) {
        super(context);
    }

    public SelectEventView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override public void setName(String pName) {
        this.mTextView.setText(pName);
    }
}
