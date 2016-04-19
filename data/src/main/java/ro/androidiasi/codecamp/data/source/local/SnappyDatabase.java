package ro.androidiasi.codecamp.data.source.local;

import android.content.Context;
import android.util.Log;

import com.snappydb.DB;
import com.snappydb.SnappyDB;
import com.snappydb.SnappydbException;

import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;

import ro.androidiasi.codecamp.data.website.Codecamp;

/**
 * Created by andrei on 20/04/16.
 */
@EBean(scope = EBean.Scope.Singleton)
public class SnappyDatabase {
    private static final String TAG = "SnappyDatabase";

    private DB mSnappyDBInstance;

    @RootContext Context mContext;

    @AfterInject public void afterMembersInject(){
        try {
            this.mSnappyDBInstance = SnappyDB.with(mContext);
        } catch (SnappydbException pE) {
            Log.e(TAG, "afterMembersInject:", pE);
        }
    }

    public void saveCodecamp(Codecamp pCodecamp){
        try {
            this.mSnappyDBInstance.put("codecamp", pCodecamp);
        } catch (SnappydbException pE) {
            Log.e(TAG, "saveCodecamp:", pE);
        }
    }

    public boolean dataExists() {
        try {
            return this.mSnappyDBInstance.exists("codecamp");
        } catch (SnappydbException pE) {
            Log.e(TAG, "dataExists: ", pE);
        }
        return false;
    }

    public Codecamp getCodecamp() {
        try {
            return mSnappyDBInstance.getObject("codecamp", Codecamp.class);
        } catch (SnappydbException pE) {
            Log.e(TAG, "getCodecamp: ", pE);
        }
        return null;
    }
}
