package ro.androidiasi.codecamp.codecampers;

import android.support.v4.widget.SwipeRefreshLayout;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EBean;

import java.util.List;

import ro.androidiasi.codecamp.data.model.DataCodecamper;
import ro.androidiasi.codecamp.data.source.IAgendaDataSource;
import ro.androidiasi.codecamp.data.source.ILoadCallback;
import ro.androidiasi.codecamp.internal.model.Codecamper;

/**
 * Created by andrei on 19/04/16.
 */
@EBean
public class CodecampersPresenter implements CodecampersContract.Presenter, SwipeRefreshLayout.OnRefreshListener {

    @Bean CodecampersAdapter mCodecampersAdapter;

    private IAgendaDataSource<Long> mRepository;
    private CodecampersContract.View mView;

    @Override public void afterViews(){
        if(mView == null){
            throw new NullPointerException("View is NULL! Please set the View first!");
        }
        if(mRepository == null){
            throw new NullPointerException("Repository is NULL! Please set the Repository first!");
        }
        this.mView.getListView().setAdapter(mCodecampersAdapter);
        this.mRepository.getCodecampersList(new ILoadCallback<List<DataCodecamper>>() {
            @Override public void onSuccess(List<DataCodecamper> pObject) {
                mCodecampersAdapter.update(Codecamper.fromDataCodecamperList(pObject));
            }

            @Override public void onFailure(Exception pE) {

            }
        });
        this.mView.getSwipeRefreshLayout().setColorSchemeResources(
                android.R.color.holo_blue_bright,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light);
        this.mView.getSwipeRefreshLayout().setOnRefreshListener(this);
    }

    public void setView(CodecampersContract.View pView) {
        mView = pView;
    }

    public void setRepository(IAgendaDataSource<Long> pRepository) {
        mRepository = pRepository;
    }

    @Override public void onRefresh() {
        this.mRepository.getCodecampersList(true, new ILoadCallback<List<DataCodecamper>>() {
            @Override public void onSuccess(List<DataCodecamper> pObject) {
                mCodecampersAdapter.update(Codecamper.fromDataCodecamperList(pObject));
                mView.getSwipeRefreshLayout().setRefreshing(false);
            }

            @Override public void onFailure(Exception pException) {
                mView.getSwipeRefreshLayout().setRefreshing(false);
            }
        });
    }
}
