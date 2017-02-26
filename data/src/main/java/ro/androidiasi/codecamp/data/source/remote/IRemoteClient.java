package ro.androidiasi.codecamp.data.source.remote;

import java.util.List;

import ro.androidiasi.codecamp.data.source.DataConference;
import ro.androidiasi.codecamp.data.source.ILoadCallback;
import ro.androidiasi.codecamp.data.source.remote.exception.DataUnavailable;

/**
 * Created by andrei on 21/04/16.
 */
public interface IRemoteClient extends ILoadCallback<String> {
    void startCodecampJsonRequest() throws DataUnavailable;
    void startConferencesRequest(ILoadCallback<List<DataConference>> pLoadCallback) throws DataUnavailable;
}
