package ro.androidiasi.codecamp.data.source.local;

import android.content.Context;
import android.util.Log;

import com.snappydb.DB;
import com.snappydb.SnappyDB;
import com.snappydb.SnappydbException;

import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;

import ro.androidiasi.codecamp.data.model.DataCodecamp;
import ro.androidiasi.codecamp.data.source.local.exception.DataNotFoundException;
import ro.androidiasi.codecamp.data.source.local.exception.UnsupportedSnappyDb;

/**
 * Created by andrei on 20/04/16.
 */
@EBean(scope = EBean.Scope.Singleton)
public class SnappyDatabase implements IDatabase{
    private static final String TAG = "SnappyDatabase";
    private static final String KEY_OBJECT_CODECAMP = "key_object_codecamp";

    private DB mSnappyDBInstance;

    @RootContext Context mContext;

    @AfterInject public void afterMembersInject(){
        try {
            this.mSnappyDBInstance = SnappyDB.with(mContext);
        } catch (SnappydbException pE) {
            Log.e(TAG, "afterMembersInject:", pE);
        }
    }

    @Override public void saveCodecamp(DataCodecamp pCodecamp) {
        try {
            this.checkForNonNull(mSnappyDBInstance).put(KEY_OBJECT_CODECAMP, pCodecamp);
        } catch (SnappydbException pE) {
            Log.e(TAG, "saveCodecamp: ", pE);
        }
    }

    @Override public boolean dataExists() throws SnappydbException {
        return this.checkForNonNull(mSnappyDBInstance).exists(KEY_OBJECT_CODECAMP);
    }

    @Override public DataCodecamp getCodecamp() throws SnappydbException {
        DataCodecamp dataCodecamp = this.checkForNonNull(mSnappyDBInstance)
                .getObject(KEY_OBJECT_CODECAMP, DataCodecamp.class);
        if(dataCodecamp == null){
            throw new DataNotFoundException();
        } else {
            return dataCodecamp;
        }
    }

    @Override public boolean isFavorite(Long pDataSessionId) {
        try {
            return this.checkForNonNull(mSnappyDBInstance).getBoolean(String.valueOf(pDataSessionId));
        } catch (SnappydbException pE) {
            Log.e(TAG, "isFavorite: ", pE);
        }
        return false;
    }

    @Override public void setSessionFavorite(Long pLong, boolean pIsFavorite) throws SnappydbException {
        this.checkForNonNull(mSnappyDBInstance).put(pLong.toString(), pIsFavorite);
    }

    @Override public void deleteCodecamp() {
        try {
            this.mSnappyDBInstance.del(KEY_OBJECT_CODECAMP);
        } catch (SnappydbException pE) {
            Log.e(TAG, "deleteCodecamp: ", pE);
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
