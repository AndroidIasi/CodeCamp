package ro.androidiasi.codecamp.data.source.remote;

/**
 * Created by andrei on 21/04/16.
 */

import android.content.Context;

import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;

import java.io.IOException;
import java.io.InputStream;

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
        String json;
        try {
            InputStream is = mContext.getAssets().open(mEventSource.getDataJsonFile());
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
            this.onSuccess(json);
        } catch (IOException ex) {
            this.onFailure(ex);
        }
    }

    public void invalidate() {

    }
}
