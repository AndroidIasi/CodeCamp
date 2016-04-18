package ro.androidiasi.codecamp.sessiondetail;

import android.graphics.drawable.Drawable;
import android.view.View;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.res.DrawableRes;

import ro.androidiasi.codecamp.R;
import ro.androidiasi.codecamp.codecampers.item.CodecamperItemContract;
import ro.androidiasi.codecamp.codecampers.item.CodecamperItemPresenter;
import ro.androidiasi.codecamp.codecampers.item.CodecamperItemView;
import ro.androidiasi.codecamp.codecampers.item.CodecamperItemView_;
import ro.androidiasi.codecamp.data.DummyRepository;
import ro.androidiasi.codecamp.data.model.DataSession;
import ro.androidiasi.codecamp.data.source.IAgendaDataSource;
import ro.androidiasi.codecamp.data.source.ILoadCallback;
import ro.androidiasi.codecamp.internal.model.Codecamper;
import ro.androidiasi.codecamp.internal.model.Session;

/**
 * Created by andrei on 18/04/16.
 */
@EBean
public class SessionDetailsPresenter implements SessionDetailsContract.Presenter{

    @DrawableRes(R.drawable.ic_action_favorite) Drawable mIsFavoriteIcon;
    @DrawableRes(R.drawable.ic_action_favorite_outline) Drawable mIsNotFavoriteIcon;

    @Bean(DummyRepository.class) IAgendaDataSource<Long> mRepository;
    @Bean(CodecamperItemPresenter.class) CodecamperItemContract.Presenter mCodecamperItemPresenter;
    @RootContext SessionDetailsActivity mSessionDetailsActivity;

    private Session mSession;

    @Override public void afterViews() {
        if(mSession == null){
            throw new NullPointerException("Session is NULL! Please set Session first!");
        }
        this.prepareToolBar();
        this.prepareFab();
        this.prepareDescription();
        this.prepareCodecampers();
    }

    private void prepareDescription() {
        this.mSessionDetailsActivity.getDescriptionTextView().setText(mSession.getDescription());
    }

    private void prepareCodecampers() {
        for (int i = 0; i < mSession.getCodecampersList().size(); i++) {
            Codecamper codecamper = mSession.getCodecampersList().get(i);
            CodecamperItemView codecamperItemView = CodecamperItemView_.build(mSessionDetailsActivity);
            this.mSessionDetailsActivity.getCodecampersContainerView().addView(codecamperItemView);
            this.onUiThreadBindCodecamperWithView(codecamper, codecamperItemView);
        }
    }

    private void prepareFab() {
        Drawable fabDrawable = this.mSession.isFavorite() ? mIsFavoriteIcon : mIsNotFavoriteIcon;
        this.mSessionDetailsActivity.getFab().setImageDrawable(fabDrawable);
        this.mSessionDetailsActivity.getFab().setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View pView) {
                onFavoritesFabClicked();
            }
        });
    }

    private void prepareToolBar() {
        this.mSessionDetailsActivity.setSupportActionBar(mSessionDetailsActivity.getToolbar());
        this.mSessionDetailsActivity.getCollapsingToolbarLayout().setTitle(mSession.getName());
        this.mSessionDetailsActivity.getSupportActionBar().setTitle(mSession.getName());
    }

    public void setSession(Session pSession) {
        this.mSession = pSession;
    }

    private void onFavoritesFabClicked(){
        this.mSession = new Session(
                mSession.getId(),
                mSession.getCodecampersList(),
                mSession.getRoom(),
                mSession.getName(),
                mSession.getDescription(),
                mSession.getTimeFrame(),
                !mSession.isFavorite()
        );
        this.mRepository.setSessionFavorite(mSession.getId(), mSession.isFavorite(), new ILoadCallback<DataSession>() {
            @Override public void onSuccess(DataSession pObject) {

            }

            @Override public void onFailure() {

            }
        });
        this.prepareFab();
    }

    @UiThread public void onUiThreadBindCodecamperWithView(Codecamper pCodecamper, CodecamperItemView pCodecamperItemView){
        this.mCodecamperItemPresenter.bind(pCodecamper, pCodecamperItemView);
    }

}
