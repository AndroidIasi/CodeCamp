package ro.androidiasi.codecamp.data.source;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EBean;

import java.util.List;

import ro.androidiasi.codecamp.data.model.DataCodecamp;
import ro.androidiasi.codecamp.data.model.DataCodecamper;
import ro.androidiasi.codecamp.data.model.DataRoom;
import ro.androidiasi.codecamp.data.model.DataSession;
import ro.androidiasi.codecamp.data.model.DataTimeFrame;
import ro.androidiasi.codecamp.data.source.local.AgendaLocalSnappyDataSource;
import ro.androidiasi.codecamp.data.source.remote.FileRemoteDataSource;
import ro.androidiasi.codecamp.data.source.remote.WebViewRemoteDataSource;

/**
 * Created by andrei on 06/04/16.
 */
@EBean(scope = EBean.Scope.Singleton)
public class AgendaRepository implements IAgendaDataSource<Long> {

    @Bean AgendaLocalSnappyDataSource mLocalSnappyDataSource;
    @Bean FileRemoteDataSource mFileRemoteDataSource;
    @Bean WebViewRemoteDataSource mWebViewRemoteDataSource;

    private DataCodecamp mMemCacheDataCodecamp;

    @Override public void getRoomsList(ILoadCallback<List<DataRoom>> pLoadCallback) {

    }

    @Override public void getSessionsList(ILoadCallback<List<DataSession>> pLoadCallback) {

    }

    @Override public void getFavoriteSessionsList(ILoadCallback<List<DataSession>> pLoadCallback) {

    }

    @Override public void getTimeFramesList(ILoadCallback<List<DataTimeFrame>> pLoadCallback) {

    }

    @Override public void getCodecampersList(ILoadCallback<List<DataCodecamper>> pLoadCallback) {

    }

    @Override public void getRoom(Long pLong, ILoadCallback<DataRoom> pLoadCallback) {

    }

    @Override public void getSession(Long pLong, ILoadCallback<DataSession> pLoadCallback) {

    }

    @Override public void getTimeFrame(Long pLong, ILoadCallback<DataTimeFrame> pLoadCallback) {

    }

    @Override public void getCodecamper(Long pLong, ILoadCallback<DataCodecamper> pLoadCallback) {

    }

    @Override public void isSessionFavorite(Long pLong, ILoadCallback<Boolean> pLoadCallback) {

    }

    @Override public void setSessionFavorite(Long pLong, boolean pFavorite, ILoadCallback<Boolean> pLoadCallback) {

    }

    @Override public <Model> void onUiThreadCallOnSuccessCallback(ILoadCallback<Model> pLoadCallback, Model pModel) {

    }

    @Override public <E extends Exception> void onUiThreadCallOnFailureCallback(ILoadCallback pLoadCallback, E pException) {

    }
}
