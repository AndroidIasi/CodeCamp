package ro.androidiasi.codecamp.data.source.local;

import android.content.Context;
import android.util.Log;

import com.snappydb.DB;
import com.snappydb.SnappyDB;
import com.snappydb.SnappydbException;

import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;

import java.util.Arrays;
import java.util.List;

import ro.androidiasi.codecamp.data.model.DataCodecamper;
import ro.androidiasi.codecamp.data.model.DataRoom;
import ro.androidiasi.codecamp.data.model.DataSession;
import ro.androidiasi.codecamp.data.model.DataTimeFrame;
import ro.androidiasi.codecamp.data.source.EventSource;
import ro.androidiasi.codecamp.data.source.local.exception.DataNotFoundException;
import ro.androidiasi.codecamp.data.source.local.exception.UnsupportedSnappyDb;

/**
 * Created by andrei on 20/04/16.
 */
@EBean(scope = EBean.Scope.Singleton)
@SuppressWarnings("SynchronizeOnNonFinalField")
public class SnappyDatabase implements IDatabase{
    private static final String TAG = "SnappyDatabase";

    private static final String KEY_ARRAY_ROOMS = "key_array_rooms";
    private static final String KEY_ARRAY_TIME_FRAMES = "key_array_time_frames";
    private static final String KEY_ARRAY_CODECAMPERS = "key_array_codecampers";
    private static final String KEY_ARRAY_SESSIONS = "key_array_sessions";

    private DB mSnappyDBInstance;

    @RootContext Context mContext;

    @AfterInject public void afterMembersInject(){
    }

    private void openDatabase(String pName) {
        try {
            this.mSnappyDBInstance = new SnappyDB.Builder(mContext)
                    .name(pName)
                    .build();
        } catch (SnappydbException pE) {
            Log.e(TAG, "afterMembersInject:", pE);
        }
    }

    @Override public boolean isDataSessionFavorite(Long pDataSessionId) {
        synchronized (mSnappyDBInstance) {
            try {
                return this.checkForNonNull(mSnappyDBInstance).getBoolean(String.valueOf(pDataSessionId));
            } catch (SnappydbException pE) {
//                Log.e(TAG, "isDataSessionFavorite: ", pE);
            }
            return false;
        }
    }

    @Override public void setDataSessionFavorite(Long pLong, boolean pIsFavorite) throws SnappydbException {
        synchronized (mSnappyDBInstance) {
            this.checkForNonNull(mSnappyDBInstance).put(pLong.toString(), pIsFavorite);
        }
    }

    @Override public void saveDataRoomsList(List<DataRoom> pDataRoomList){
        this.putList(KEY_ARRAY_ROOMS, pDataRoomList);
    }

    @Override public List<DataRoom> getDataRooms() throws SnappydbException {
        return this.getList(KEY_ARRAY_ROOMS, DataRoom.class);
    }

    @Override public void deleteDataRooms(){
        synchronized (mSnappyDBInstance) {
            try {
                this.checkForNonNull(mSnappyDBInstance).del(KEY_ARRAY_ROOMS);
            } catch (SnappydbException pE) {
                Log.e(TAG, "deleteDataRooms: ", pE);
            }
        }
    }

    @Override public void saveDataTimeFrames(List<DataTimeFrame> pTimeFrameList){
        this.putList(KEY_ARRAY_TIME_FRAMES, pTimeFrameList);
    }

    @Override public List<DataTimeFrame> getDataTimeFrames() throws SnappydbException {
        return this.getList(KEY_ARRAY_TIME_FRAMES, DataTimeFrame.class);
    }

    @Override public void deleteDataTimeFrames(){
        synchronized (mSnappyDBInstance) {
            try {
                this.checkForNonNull(mSnappyDBInstance).del(KEY_ARRAY_TIME_FRAMES);
            } catch (SnappydbException pE) {
                Log.e(TAG, "deleteDataTimeFrames: ", pE);
            }
        }
    }

    @Override public void saveDataCodecampers(List<DataCodecamper> pCodecamperList){
        this.putList(KEY_ARRAY_CODECAMPERS, pCodecamperList);
    }

    @Override public List<DataCodecamper> getDataCodecampers() throws SnappydbException {
        return this.getList(KEY_ARRAY_CODECAMPERS, DataCodecamper.class);
    }

    @Override public void deleteDataCodecampers(){
        synchronized (mSnappyDBInstance) {
            try {
                this.checkForNonNull(mSnappyDBInstance).del(KEY_ARRAY_CODECAMPERS);
            } catch (SnappydbException pE) {
                Log.e(TAG, "deleteDataCodecampers: ", pE);
            }
        }
    }

    @Override public void saveDataSessions(List<DataSession> pDataSessions){
        this.putList(KEY_ARRAY_SESSIONS, pDataSessions);
    }

    @Override public List<DataSession> getDataSessions() throws SnappydbException {
        return this.getList(KEY_ARRAY_SESSIONS, DataSession.class);
    }

    @Override public void deleteDataSessions(){
        synchronized (mSnappyDBInstance) {
            try {
                this.checkForNonNull(mSnappyDBInstance).del(KEY_ARRAY_SESSIONS);
            } catch (SnappydbException pE) {
                Log.e(TAG, "deleteDataSessions: ", pE);
            }
        }
    }

    @Override public boolean dataRoomsExist(){
        return this.dataExists(KEY_ARRAY_ROOMS);
    }

    @Override public boolean dataTimeFramesExist(){
        return this.dataExists(KEY_ARRAY_TIME_FRAMES);
    }

    @Override public boolean dataCodecampersExist(){
        return this.dataExists(KEY_ARRAY_CODECAMPERS);
    }

    @Override public boolean dataSessionsExist(){
        return this.dataExists(KEY_ARRAY_SESSIONS);
    }

    @Override public void setEventSource(EventSource pEventSource) {
        this.openDatabase(pEventSource.toString());
    }


    private<Model> void putList(String pKey, List<Model> pModelList){
        synchronized (mSnappyDBInstance) {
            try {
                this.checkForNonNull(mSnappyDBInstance).put(pKey, pModelList.toArray());
            } catch (SnappydbException pE) {
                Log.e(TAG, "putList: ", pE);
            }
        }
    }

    private<Model> List<Model> getList(String pKey, Class<Model> pModelClass) throws SnappydbException {
        synchronized (mSnappyDBInstance) {
            Model[] modelsArray = this.checkForNonNull(mSnappyDBInstance).getObjectArray(pKey, pModelClass);
            if (modelsArray == null) {
                throw new DataNotFoundException();
            } else {
                return Arrays.asList(modelsArray);
            }
        }
    }

    private boolean dataExists(String pKey){
        synchronized (mSnappyDBInstance) {
            try {
                return this.checkForNonNull(mSnappyDBInstance).exists(pKey);
            } catch (SnappydbException pE) {
                Log.e(TAG, "dataExist: ", pE);
            }
            return false;
        }
    }

    private DB checkForNonNull(DB pSnappyDatabase) throws SnappydbException {
        if(pSnappyDatabase == null){
            throw new UnsupportedSnappyDb();
        } else {
            return pSnappyDatabase;
        }
    }
}
