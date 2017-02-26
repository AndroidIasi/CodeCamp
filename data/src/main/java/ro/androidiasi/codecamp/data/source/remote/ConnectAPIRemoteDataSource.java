package ro.androidiasi.codecamp.data.source.remote;

/**
 * Created by andrei on 21/04/16.
 */

import android.support.annotation.NonNull;

import org.androidannotations.annotations.EBean;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.List;

import ro.androidiasi.codecamp.data.source.DataConference;
import ro.androidiasi.codecamp.data.source.ILoadCallback;
import ro.androidiasi.codecamp.data.source.remote.exception.DataUnavailable;

/**
 * Does the same as {@link FileRemoteDataSource} but with a file from the double-iu-s
 */
@EBean
public class ConnectAPIRemoteDataSource extends BaseRemoteDataSource{

    @Override public void startCodecampJsonRequest() throws DataUnavailable {
        super.startCodecampJsonRequest();
        try {
            String url = mConference.getConnectJsonURL();
            String jsonData = retrieveDataFromUrl(url);
            this.onSuccess(jsonData);
        } catch (IOException ex) {
            this.onFailure(ex);
        }
    }

    @Override
    public void startConferencesRequest(ILoadCallback<List<DataConference>> pLoadCallback) throws DataUnavailable {
        try {
            String url = DataConference.CONFERENCES_LIST_URL;
            String jsonData = retrieveDataFromUrl(url);
            pLoadCallback.onSuccess(getDataConferencesFromJson(jsonData));
        } catch (IOException ex) {
            this.onFailure(ex);
        }
    }

    @NonNull private String retrieveDataFromUrl(String url) throws IOException {
        StringBuilder json = new StringBuilder();
        URL codecampJsonURL = new URL(url);
        BufferedReader in = new BufferedReader(
                new InputStreamReader(
                        codecampJsonURL.openStream(), "UTF-8"));
        String inputLine;
        while ((inputLine = in.readLine()) != null)
            json.append(inputLine);
        in.close();
        return json.toString();
    }

    public void invalidate() {

    }
}
