package ro.androidiasi.codecamp.data.source.local;

import android.util.Log;

import com.snappydb.SnappydbException;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EBean;

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
public class AgendaLocalSnappyDataSource implements IAgendaDataSource<Long> {

    private static final String TAG = "AgendaSnappyDataSource";

    @Bean(SnappyDatabase.class) IDatabase mSnappyDatabase;

    @Override public void getRoomsList(ILoadCallback<List<DataRoom>> pLoadCallback) {
        try {
            List<DataRoom> dataRoomList = this.mSnappyDatabase.getCodecamp().getDataRooms();
            this.onSuccess(pLoadCallback, dataRoomList);
        } catch (SnappydbException pE) {
            this.onFailure(pLoadCallback, pE);
        }
    }

    @Override public void getSessionsList(ILoadCallback<List<DataSession>> pLoadCallback) {
        try {
            List<DataSession> dataSessionList = this.mSnappyDatabase.getCodecamp().getDataSessions();
            this.onSuccess(pLoadCallback, dataSessionList);
        } catch (SnappydbException pE) {
            this.onFailure(pLoadCallback, pE);
        }
    }

    @Override public void getFavoriteSessionsList(ILoadCallback<List<DataSession>> pLoadCallback) {
        List<DataSession> favoriteSessionsList = new ArrayList<>();
        try {
            List<DataSession> dataSessionList = this.mSnappyDatabase.getCodecamp().getDataSessions();
            for (int i = 0; i < dataSessionList.size(); i++) {
                if(mSnappyDatabase.isFavorite(dataSessionList.get(i).getId())){
                    favoriteSessionsList.add(dataSessionList.get(i));
                }
            }
            this.onSuccess(pLoadCallback, favoriteSessionsList);
        } catch (SnappydbException pE) {
            this.onFailure(pLoadCallback, pE);
        }
    }

    @Override public void getTimeFramesList(ILoadCallback<List<DataTimeFrame>> pLoadCallback) {
        try {
            List<DataTimeFrame> dataTimeFrameList = this.mSnappyDatabase.getCodecamp().getTimeFrames();
            this.onSuccess(pLoadCallback, dataTimeFrameList);
        } catch (SnappydbException pE) {
            this.onFailure(pLoadCallback, pE);
        }
    }

    @Override public void getCodecampersList(ILoadCallback<List<DataCodecamper>> pLoadCallback) {
        try {
            List<DataCodecamper> dataCodecamperList = this.mSnappyDatabase.getCodecamp().getDataCodecampers();
            this.onSuccess(pLoadCallback, dataCodecamperList);
        } catch (SnappydbException pE) {
            this.onFailure(pLoadCallback, pE);
        }
    }

    @Override public void getRoom(Long pLong, ILoadCallback<DataRoom> pLoadCallback) {

    }

    @Override public void getSession(Long pLong, ILoadCallback<DataSession> pLoadCallback) {

    }

    @Override public void getTimeFrame(Long pLong, ILoadCallback<DataTimeFrame> pLoadCallback) {

    }

    @Override public void getCodecamper(Long pLong, ILoadCallback<DataCodecamper> pLoadCallback) {

    }

    @Override public void isSessionFavorite(Long pLong, final ILoadCallback<Boolean> pLoadCallback) {
        final boolean isFavorite;
        try {
            isFavorite = mSnappyDatabase.isFavorite(pLong);
            this.onSuccess(pLoadCallback, isFavorite);
        } catch (SnappydbException pE) {
            this.onFailure(pLoadCallback, pE);
        }
    }

    @Override public void setSessionFavorite(Long pLong, final boolean pFavorite, final ILoadCallback<Boolean> pLoadCallback) {
        try {
            mSnappyDatabase.setSessionFavorite(pLong, pFavorite);
            this.onSuccess(pLoadCallback, pFavorite);
        } catch (final SnappydbException pE) {
            this.onFailure(pLoadCallback, pE);
        }
    }

    private<Model> void onSuccess(ILoadCallback<Model> pLoadCallback, Model pFavorite) {
        pLoadCallback.onSuccess(pFavorite);
    }

    public void onFailure(ILoadCallback pLoadCallback, Exception pException){
        Log.e(TAG, "onFailure: ", pException);
        pLoadCallback.onFailure(pException);
    }

    public void invalidate() {
        this.mSnappyDatabase.deleteCodecamp();
    }
}
