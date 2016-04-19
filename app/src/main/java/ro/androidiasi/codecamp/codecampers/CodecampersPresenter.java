package ro.androidiasi.codecamp.codecampers;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EBean;

import java.util.List;

import ro.androidiasi.codecamp.data.model.DataCodecamper;
import ro.androidiasi.codecamp.data.source.AgendaRepository;
import ro.androidiasi.codecamp.data.source.IAgendaDataSource;
import ro.androidiasi.codecamp.data.source.ILoadCallback;
import ro.androidiasi.codecamp.internal.model.Codecamper;

/**
 * Created by andrei on 19/04/16.
 */
@EBean
public class CodecampersPresenter implements CodecampersContract.Presenter{

    @Bean CodecampersAdapter mCodecampersAdapter;
    @Bean(AgendaRepository.class) IAgendaDataSource<Long> mRepository;
    private CodecampersContract.View mView;

    @Override public void afterViews(){
        if(mView == null){
            throw new NullPointerException("View is NULL! Please set the View first!");
        }
        this.mView.getListView().setAdapter(mCodecampersAdapter);
        this.mRepository.getCodecampersList(new ILoadCallback<List<DataCodecamper>>() {
            @Override public void onSuccess(List<DataCodecamper> pObject) {
                mCodecampersAdapter.update(Codecamper.fromDataCodecamperList(pObject));
            }

            @Override public void onFailure() {

            }
        });
    }

    public void setView(CodecampersContract.View pView) {
        mView = pView;
    }
}
