package ro.androidiasi.codecamp.sessiondetail;

import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.res.DrawableRes;

import ro.androidiasi.codecamp.Navigator;
import ro.androidiasi.codecamp.R;
import ro.androidiasi.codecamp.codecampers.item.CodecamperItemContract;
import ro.androidiasi.codecamp.codecampers.item.CodecamperItemPresenter;
import ro.androidiasi.codecamp.codecampers.item.CodecamperItemView;
import ro.androidiasi.codecamp.codecampers.item.CodecamperItemView_;
import ro.androidiasi.codecamp.data.source.IAgendaDataSource;
import ro.androidiasi.codecamp.data.source.ILoadCallback;
import ro.androidiasi.codecamp.internal.bus.CodecampBus;
import ro.androidiasi.codecamp.internal.model.Codecamper;
import ro.androidiasi.codecamp.internal.model.Session;

/**
 * Created by andrei on 18/04/16.
 */
@EBean
public class SessionDetailsPresenter implements SessionDetailsContract.Presenter{

    private static final String TAG = "SessionDetailsPresenter";
    @DrawableRes(R.drawable.ic_star_24dp) Drawable mIsFavoriteIcon;
    @DrawableRes(R.drawable.ic_star_outline_24dp) Drawable mIsNotFavoriteIcon;

    @Bean Navigator mNavigator;
    @Bean(CodecamperItemPresenter.class) CodecamperItemContract.Presenter mCodecamperItemPresenter;
    @Bean CodecampBus mCodecampBus;

    @RootContext SessionDetailsActivity mSessionDetailsActivity;

    private IAgendaDataSource<Long> mRepository;
    private Session mSession;
    private boolean mIsSessionFavorite;

    @Override public void afterViews() {
        if(mSession == null){
            throw new NullPointerException("Session is NULL! Please set Session first!");
        }
        if(mRepository == null){
            throw new NullPointerException("Repository is NULL! Please set the Repository first!");
        }
        this.prepareToolBar();
        this.prepareFab();
        this.prepareTitle();
        this.prepareDescription();
        this.prepareLocation();
        this.prepareCodecampers();
    }

    private void prepareTitle() {
        this.mSessionDetailsActivity.getTitleTextView().setText(mSession.getName());
    }

    private void prepareLocation() {
        String location = mSessionDetailsActivity.getString(
                R.string.session_track_name_and_floor,
                mSession.getRoom().getName(),
                mSession.getRoom().getDescription());
        this.mSessionDetailsActivity.getLocationTextView().setText(location);
    }

    private void prepareDescription() {
        this.mSessionDetailsActivity.getDescriptionTextView().setText(mSession.getDescription());
    }

    private void prepareCodecampers() {
        for (int i = 0; i < mSession.getCodecampersList().size(); i++) {
            final Codecamper codecamper = mSession.getCodecampersList().get(i);
            CodecamperItemView codecamperItemView = CodecamperItemView_.build(mSessionDetailsActivity);
            codecamperItemView.setClickable(true);
            codecamperItemView.setOnClickListener(new View.OnClickListener() {
                @Override public void onClick(View v) {
                    mNavigator.goToCodecamperDetails(mSessionDetailsActivity.getSupportFragmentManager(), codecamper);
                }
            });
            this.mSessionDetailsActivity.getCodecampersContainerView().addView(codecamperItemView);
            this.onUiThreadBindCodecamperWithView(codecamper, codecamperItemView);
        }
    }

    private void prepareFab() {
        this.mRepository.isSessionFavorite(mSession.getId(), new ILoadCallback<Boolean>() {
            @Override public void onSuccess(Boolean pObject) {
                mIsSessionFavorite = pObject;
                Drawable fabDrawable = pObject ? mIsFavoriteIcon : mIsNotFavoriteIcon;
                mSessionDetailsActivity.getFab().setImageDrawable(fabDrawable);
            }

            @Override public void onFailure(Exception pException) {
                mSessionDetailsActivity.getFab().setImageDrawable(mIsNotFavoriteIcon);
            }
        });
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
        this.mRepository.setSessionFavorite(mSession.getId(), !mIsSessionFavorite, new ILoadCallback<Boolean>() {
            @Override public void onSuccess(Boolean pObject) {
                mIsSessionFavorite = pObject;
                Drawable fabDrawable = pObject ? mIsFavoriteIcon : mIsNotFavoriteIcon;
                mSessionDetailsActivity.getFab().setImageDrawable(fabDrawable);
                mCodecampBus.postSticky(new EventSessionUpdated());
                String message = pObject ? "Session added to Favorites" : "Session removed from Favorites";
                Toast.makeText(mSessionDetailsActivity, message, Toast.LENGTH_SHORT).show();
            }

            @Override public void onFailure(Exception pE) {
                Log.e(TAG, "onFailure: ", pE);
            }
        });
    }

    @UiThread public void onUiThreadBindCodecamperWithView(Codecamper pCodecamper, CodecamperItemView pCodecamperItemView){
        this.mCodecamperItemPresenter.bind(pCodecamper, pCodecamperItemView);
    }

    public void setRepository(IAgendaDataSource<Long> pRepository) {
        mRepository = pRepository;
    }
}
