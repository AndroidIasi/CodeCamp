package ro.androidiasi.codecamp.data.source;

import java.util.List;

import ro.androidiasi.codecamp.data.model.Codecamper;
import ro.androidiasi.codecamp.data.model.Room;
import ro.androidiasi.codecamp.data.model.Session;
import ro.androidiasi.codecamp.data.model.TimeFrame;

/**
 * Created by andrei on 06/04/16.
 */
public interface IAgendaDataSource {

    void getRoomsList(ILoadCallback<List<Room>> pLoadCallback);
    void getSessionsList(ILoadCallback<List<Session>> pLoadCallback);
    void getTimeFramesList(ILoadCallback<List<TimeFrame>> pLoadCallback);
    void getCodecampersList(ILoadCallback<List<Codecamper>> pLoadCallback);

    void getRoom(int pId, ILoadCallback<Room> pLoadCallback);
    void getSession(int pId, ILoadCallback<Session> pLoadCallback);
    void getTimeFrame(int pId, ILoadCallback<TimeFrame> pLoadCallback);
    void getCodecamper(int pId, ILoadCallback<Codecamper> pLoadCallback);

    void setSessionFavorite(int pSessionId, boolean pFavorite, ILoadCallback<Session> pLoadCallback);
}
