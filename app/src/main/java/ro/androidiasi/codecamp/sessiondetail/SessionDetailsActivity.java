package ro.androidiasi.codecamp.sessiondetail;

import android.content.Context;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.Toolbar;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.Extra;
import org.androidannotations.annotations.ViewById;

import ro.androidiasi.codecamp.BaseActivity;
import ro.androidiasi.codecamp.R;
import ro.androidiasi.codecamp.internal.model.Session;

@EActivity(R.layout.activity_session_details)
public class SessionDetailsActivity extends BaseActivity implements SessionDetailsContract.View{

    @Bean(SessionDetailsPresenter.class) SessionDetailsContract.Presenter mSessionDetailsPresenter;
    @Extra Session mSession;

    @ViewById(R.id.fab) FloatingActionButton mFab;
    @ViewById(R.id.toolbar) Toolbar mToolbar;
    @ViewById(R.id.toolbar_layout) CollapsingToolbarLayout mCollapsingToolbarLayout;
    @ViewById(R.id.description) TextView mDescriptionTextView;

    @ViewById(R.id.codecampers_container) LinearLayout mCodecampersContainerView;
    @ViewById(R.id.location) TextView mLocationTextView;
    @ViewById(R.id.title) TextView mTitleTextView;

    public static void start(Context pContext, Session pSession) {
        SessionDetailsActivity_.intent(pContext)
                .mSession(pSession)
                .start();
    }

    @Override public void afterViews() {
        super.afterViews();
        this.mSessionDetailsPresenter.setSession(mSession);
        this.mSessionDetailsPresenter.afterViews();
    }

    public Toolbar getToolbar() {
        return mToolbar;
    }

    public CollapsingToolbarLayout getCollapsingToolbarLayout() {
        return mCollapsingToolbarLayout;
    }

    public FloatingActionButton getFab() {
        return mFab;
    }

    public TextView getDescriptionTextView() {
        return mDescriptionTextView;
    }

    public LinearLayout getCodecampersContainerView() {
        return mCodecampersContainerView;
    }

    public TextView getLocationTextView() {
        return mLocationTextView;
    }

    public TextView getTitleTextView() {
        return mTitleTextView;
    }
}
