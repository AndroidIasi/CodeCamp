package ro.androidiasi.codecamp.internal.recycler;

import android.support.v7.widget.RecyclerView;

/**
 * Created by andrei on 10/04/16.
 */
public class ViewDecorator<View extends android.view.View> extends RecyclerView.ViewHolder {

    private View mView;

    public ViewDecorator(View itemView) {
        super(itemView);
        this.mView = itemView;
    }

    public View getView() {
        return mView;
    }
}
