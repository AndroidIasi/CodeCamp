package ro.androidiasi.codecamp.data.source.remote;

/**
 * Created by andrei on 21/04/16.
 */

import android.content.Context;
import android.support.annotation.NonNull;

import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import ro.androidiasi.codecamp.data.source.DataConference;
import ro.androidiasi.codecamp.data.source.ILoadCallback;
import ro.androidiasi.codecamp.data.source.remote.exception.DataUnavailable;

/**
 * Used to have some data available when the app starts
 * The idea is to have the user engaged in the app,
 * not waiting for the data to be fetched,
 * and in background we refresh the data
 */
@EBean
public class FileRemoteDataSource extends BaseRemoteDataSource{

    @RootContext Context mContext;

    @Override public void startCodecampJsonRequest() throws DataUnavailable {
        super.startCodecampJsonRequest();
        try {
            String file = mConference.getDataJsonFile();
            String json = retrieveStringFromFile(file);
            this.onSuccess(json);
        } catch (IOException ex) {
            this.onFailure(ex);
        }
    }

    @Override
    public void startConferencesRequest(ILoadCallback<List<DataConference>> pLoadCallback) throws DataUnavailable {
        try {
            String file = DataConference.CONFERENCES_LIST_LOCAL_FILE;
            String json = retrieveStringFromFile(file);
            pLoadCallback.onSuccess(getDataConferencesFromJson(json));
        } catch (IOException ex) {
            this.onFailure(ex);
        }
    }

    @NonNull private String retrieveStringFromFile(String file) throws IOException {
        String json;
        InputStream is = mContext.getAssets().open(file);
        int size = is.available();
        byte[] buffer = new byte[size];
        is.read(buffer);
        is.close();
        json = new String(buffer, "UTF-8");
        return json;
    }

    public void invalidate() {

    }
}
