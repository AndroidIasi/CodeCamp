package ro.androidiasi.codecamp.data.source.remote;

import ro.androidiasi.codecamp.data.source.ILoadCallback;
import ro.androidiasi.codecamp.data.source.remote.exception.DataUnavailable;

/**
 * Created by andrei on 21/04/16.
 */
public interface IRemoteClient extends ILoadCallback<String> {
    void startCodecampJsonRequest() throws DataUnavailable;
}
