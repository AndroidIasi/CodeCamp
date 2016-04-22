package ro.androidiasi.codecamp.data.source.local;

import android.util.Log;

import com.snappydb.SnappydbException;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EBean;

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

    @Bean(SnappyDatabase.class) IDatabase mDatabase;

    @Override public void getRoomsList(boolean pForced, ILoadCallback<List<DataRoom>> pLoadCallback) {
        try {
            List<DataRoom> dataRoomList = this.mDatabase.getDataRooms();
            this.onSuccess(pLoadCallback, dataRoomList);
        } catch (SnappydbException pE) {
            this.onFailure(pLoadCallback, pE);
        }
    }

    @Override public void getSessionsList(boolean pForced, ILoadCallback<List<DataSession>> pLoadCallback) {
        try {
            List<DataSession> dataSessionList = this.mDatabase.getDataSessions();
            this.onSuccess(pLoadCallback, dataSessionList);
        } catch (SnappydbException pE) {
            this.onFailure(pLoadCallback, pE);
        }
    }

    @Override public void getFavoriteSessionsList(boolean pFroced, ILoadCallback<List<DataSession>> pLoadCallback) {

    }

    @Override public void getTimeFramesList(boolean pForced, ILoadCallback<List<DataTimeFrame>> pLoadCallback) {
        try {
            List<DataTimeFrame> dataTimeFrameList = this.mDatabase.getDataTimeFrames();
            this.onSuccess(pLoadCallback, dataTimeFrameList);
        } catch (SnappydbException pE) {
            this.onFailure(pLoadCallback, pE);
        }
    }

    @Override public void getCodecampersList(boolean pForced, ILoadCallback<List<DataCodecamper>> pLoadCallback) {
        try {
            List<DataCodecamper> dataCodecamperList = this.mDatabase.getDataCodecampers();
            this.onSuccess(pLoadCallback, dataCodecamperList);
        } catch (SnappydbException pE) {
            this.onFailure(pLoadCallback, pE);
        }
    }

    @Override public void getRoomsList(ILoadCallback<List<DataRoom>> pLoadCallback) {
        this.getRoomsList(false, pLoadCallback);
    }

    @Override public void getSessionsList(ILoadCallback<List<DataSession>> pLoadCallback) {
        this.getSessionsList(false, pLoadCallback);
    }

    @Override public void getFavoriteSessionsList(ILoadCallback<List<DataSession>> pLoadCallback) {
        this.getFavoriteSessionsList(false, pLoadCallback);
    }

    @Override public void getTimeFramesList(ILoadCallback<List<DataTimeFrame>> pLoadCallback) {
        this.getTimeFramesList(false, pLoadCallback);
    }

    @Override public void getCodecampersList(ILoadCallback<List<DataCodecamper>> pLoadCallback) {
        this.getCodecampersList(false, pLoadCallback);
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
            isFavorite = mDatabase.isDataSessionFavorite(pLong);
            this.onSuccess(pLoadCallback, isFavorite);
        } catch (SnappydbException pE) {
            this.onFailure(pLoadCallback, pE);
        }
    }

    @Override public void setSessionFavorite(Long pLong, final boolean pFavorite, final ILoadCallback<Boolean> pLoadCallback) {
        try {
            mDatabase.setDataSessionFavorite(pLong, pFavorite);
            this.onSuccess(pLoadCallback, pFavorite);
        } catch (final SnappydbException pE) {
            this.onFailure(pLoadCallback, pE);
        }
    }

    public void storeDataRooms(List<DataRoom> pDataRoomList){
        this.mDatabase.saveDataRoomsList(pDataRoomList);
    }

    public void storeDataTimeFrames(List<DataTimeFrame> pTimeFrameList){
        this.mDatabase.saveDataTimeFrames(pTimeFrameList);
    }

    public void storeDataCodecampers(List<DataCodecamper> pDataCodecamperList){
        this.mDatabase.saveDataCodecampers(pDataCodecamperList);
    }

    public void storeDataSessions(List<DataSession> pDataSessionList){
        this.mDatabase.saveDataSessions(pDataSessionList);
    }

    private<Model> void onSuccess(ILoadCallback<Model> pLoadCallback, Model pFavorite) {
        pLoadCallback.onSuccess(pFavorite);
    }

    private void onFailure(ILoadCallback pLoadCallback, Exception pException){
        Log.e(TAG, "onFailure: ", pException);
        pLoadCallback.onFailure(pException);
    }

    public void invalidate() {
        this.mDatabase.deleteDataRooms();
        this.mDatabase.deleteDataCodecampers();
        this.mDatabase.deleteDataTimeFrames();
        this.mDatabase.deleteDataSessions();
    }

    public void invalidateDataRooms() {
        this.mDatabase.deleteDataRooms();
    }

    public void invalidateDataTimeFrames(){
        this.mDatabase.deleteDataTimeFrames();
    }

    public void invalidateDataCodecampers(){
        this.mDatabase.deleteDataCodecampers();
    }

    public void invalidateDataSessions(){
        this.mDatabase.deleteDataSessions();
    }
}
