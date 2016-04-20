package ro.androidiasi.codecamp.sessiondetail;

import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.Toolbar;
import android.widget.LinearLayout;
import android.widget.TextView;

import ro.androidiasi.codecamp.internal.IPresenter;
import ro.androidiasi.codecamp.internal.IView;
import ro.androidiasi.codecamp.internal.model.Session;

/**
 * Created by andrei on 18/04/16.
 */
public interface SessionDetailsContract {
    public interface View extends IView{

        void afterViews();

        Toolbar getToolbar();

        CollapsingToolbarLayout getCollapsingToolbarLayout();

        FloatingActionButton getFab();

        TextView getDescriptionTextView();

        LinearLayout getCodecampersContainerView();

        TextView getLocationTextView();

        TextView getTitleTextView();
    }

    public interface Presenter extends IPresenter{

        void afterViews();

        void setSession(Session pSession);
    }
}
