package ro.androidiasi.codecamp.data.source;

import java.util.List;

import ro.androidiasi.codecamp.data.model.DataCodecamper;
import ro.androidiasi.codecamp.data.model.DataRoom;
import ro.androidiasi.codecamp.data.model.DataSession;
import ro.androidiasi.codecamp.data.model.DataTimeFrame;

/**
 * Created by andrei on 06/04/16.
 */
public interface IAgendaDataSource {

    void getRoomsList(ILoadCallback<List<DataRoom>> pLoadCallback);
    void getSessionsList(ILoadCallback<List<DataSession>> pLoadCallback);
    void getTimeFramesList(ILoadCallback<List<DataTimeFrame>> pLoadCallback);
    void getCodecampersList(ILoadCallback<List<DataCodecamper>> pLoadCallback);

    void getRoom(int pId, ILoadCallback<DataRoom> pLoadCallback);
    void getSession(int pId, ILoadCallback<DataSession> pLoadCallback);
    void getTimeFrame(int pId, ILoadCallback<DataTimeFrame> pLoadCallback);
    void getCodecamper(int pId, ILoadCallback<DataCodecamper> pLoadCallback);

    void isSessionFavorite(int pSessionId, ILoadCallback<DataSession> pLoadCallback);
    void setSessionFavorite(int pSessionId, boolean pFavorite, ILoadCallback<DataSession> pLoadCallback);
}
