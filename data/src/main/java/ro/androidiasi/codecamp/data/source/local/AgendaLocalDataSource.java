package ro.androidiasi.codecamp.data.source.local;

import android.util.Log;

import com.snappydb.SnappydbException;

import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.UiThread;

import java.util.ArrayList;
import java.util.List;

import ro.androidiasi.codecamp.data.model.DataCodecamper;
import ro.androidiasi.codecamp.data.model.DataRoom;
import ro.androidiasi.codecamp.data.model.DataSession;
import ro.androidiasi.codecamp.data.model.DataTimeFrame;
import ro.androidiasi.codecamp.data.source.IAgendaDataSource;
import ro.androidiasi.codecamp.data.source.ILoadCallback;

/**
 * Created by andrei on 06/04/16.
 */
@EBean
public class AgendaLocalDataSource implements IAgendaDataSource<Long> {

    private static final String TAG = "AgendaLocalDataSource";

    @Bean(SnappyDatabase.class) IDatabase mSnappyDatabase;

    @Background
    @Override public void getRoomsList(ILoadCallback<List<DataRoom>> pLoadCallback) {
        try {
            List<DataRoom> dataRoomList = this.mSnappyDatabase.getCodecamp().getDataRooms();
            this.onUiThreadCallOnSuccessCallback(pLoadCallback, dataRoomList);
        } catch (SnappydbException pE) {
            this.onUiThreadCallOnFailureCallback(pLoadCallback, pE);
        }
    }

    @Background
    @Override public void getSessionsList(ILoadCallback<List<DataSession>> pLoadCallback) {
        try {
            List<DataSession> dataSessionList = this.mSnappyDatabase.getCodecamp().getDataSessions();
            this.onUiThreadCallOnSuccessCallback(pLoadCallback, dataSessionList);
        } catch (SnappydbException pE) {
            this.onUiThreadCallOnFailureCallback(pLoadCallback, pE);
        }
    }

    @Background
    @Override public void getFavoriteSessionsList(ILoadCallback<List<DataSession>> pLoadCallback) {
        List<DataSession> favoriteSessionsList = new ArrayList<>();
        try {
            List<DataSession> dataSessionList = this.mSnappyDatabase.getCodecamp().getDataSessions();
            for (int i = 0; i < dataSessionList.size(); i++) {
                if(mSnappyDatabase.isFavorite(dataSessionList.get(i).getId())){
                    favoriteSessionsList.add(dataSessionList.get(i));
                }
            }
            this.onUiThreadCallOnSuccessCallback(pLoadCallback, favoriteSessionsList);
        } catch (SnappydbException pE) {
            this.onUiThreadCallOnFailureCallback(pLoadCallback, pE);
        }
    }

    @Background
    @Override public void getTimeFramesList(ILoadCallback<List<DataTimeFrame>> pLoadCallback) {
        try {
            List<DataTimeFrame> dataTimeFrameList = this.mSnappyDatabase.getCodecamp().getTimeFrames();
            this.onUiThreadCallOnSuccessCallback(pLoadCallback, dataTimeFrameList);
        } catch (SnappydbException pE) {
            this.onUiThreadCallOnFailureCallback(pLoadCallback, pE);
        }
    }

    @Background
    @Override public void getCodecampersList(ILoadCallback<List<DataCodecamper>> pLoadCallback) {
        try {
            List<DataCodecamper> dataCodecamperList = this.mSnappyDatabase.getCodecamp().getDataCodecampers();
            this.onUiThreadCallOnSuccessCallback(pLoadCallback, dataCodecamperList);
        } catch (SnappydbException pE) {
            this.onUiThreadCallOnFailureCallback(pLoadCallback, pE);
        }
    }

    @Background
    @Override public void getRoom(Long pLong, ILoadCallback<DataRoom> pLoadCallback) {

    }

    @Background
    @Override public void getSession(Long pLong, ILoadCallback<DataSession> pLoadCallback) {

    }

    @Background
    @Override public void getTimeFrame(Long pLong, ILoadCallback<DataTimeFrame> pLoadCallback) {

    }

    @Background
    @Override public void getCodecamper(Long pLong, ILoadCallback<DataCodecamper> pLoadCallback) {

    }

    @Background
    @Override public void isSessionFavorite(Long pLong, final ILoadCallback<Boolean> pLoadCallback) {
        final boolean isFavorite;
        try {
            isFavorite = mSnappyDatabase.isFavorite(pLong);
            this.onUiThreadCallOnSuccessCallback(pLoadCallback, isFavorite);
        } catch (SnappydbException pE) {
            this.onUiThreadCallOnFailureCallback(pLoadCallback, pE);
        }
    }

    @Override public void setSessionFavorite(Long pLong, final boolean pFavorite, final ILoadCallback<Boolean> pLoadCallback) {
        try {
            mSnappyDatabase.setSessionFavorite(pLong, pFavorite);
            this.onUiThreadCallOnSuccessCallback(pLoadCallback, pFavorite);
        } catch (final SnappydbException pE) {
            this.onUiThreadCallOnFailureCallback(pLoadCallback, pE);
        }
    }

    @UiThread public<Model> void onUiThreadCallOnSuccessCallback(ILoadCallback<Model> pLoadCallback, Model pModel){
        pLoadCallback.onSuccess(pModel);
    }

    @UiThread public<E extends Exception> void onUiThreadCallOnFailureCallback(ILoadCallback pLoadCallback, E pException){
        Log.e(TAG, "onUiThreadCallOnFailureCallback: ", pException);
        pLoadCallback.onFailure(pException);
    }

}
