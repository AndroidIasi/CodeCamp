package ro.androidiasi.codecamp.data.source.remote;

/**
 * Created by andrei on 21/04/16.
 */

import android.content.Context;

import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

import ro.androidiasi.codecamp.data.source.remote.exception.DataUnavailable;

/**
 * Does the same as {@link FileRemoteDataSource} but with a file from the double-iu-s
 */
@EBean
public class ConnectAPIRemoteDataSource extends BaseRemoteDataSource{

    @Override public void startCodecampJsonRequest() throws DataUnavailable {
        super.startCodecampJsonRequest();
        StringBuilder json = new StringBuilder();
        try {
            URL codecampJsonURL = new URL(mConference.getConnectJsonURL());
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(
                            codecampJsonURL.openStream()));
            String inputLine;
            while ((inputLine = in.readLine()) != null)
                json.append(inputLine);
            in.close();
            this.onSuccess(json.toString());
        } catch (IOException ex) {
            this.onFailure(ex);
        }
    }

    public void invalidate() {

    }
}
