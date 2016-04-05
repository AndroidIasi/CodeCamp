package ro.androidiasi.codecamp.data.source.remote;

import java.util.List;

import ro.androidiasi.codecamp.data.model.Codecamper;
import ro.androidiasi.codecamp.data.model.Room;
import ro.androidiasi.codecamp.data.model.Session;
import ro.androidiasi.codecamp.data.model.TimeFrame;
import ro.androidiasi.codecamp.data.source.IAgendaDataSource;
import ro.androidiasi.codecamp.data.source.ILoadCallback;

/**
 * Created by andrei on 06/04/16.
 */
public class AgendaRemoteDataSource implements IAgendaDataSource {

    @Override public void getRoomsList(ILoadCallback<List<Room>> pLoadCallback) {

    }

    @Override public void getSessionsList(ILoadCallback<List<Session>> pLoadCallback) {

    }

    @Override public void getTimeFramesList(ILoadCallback<List<TimeFrame>> pLoadCallback) {

    }

    @Override public void getCodecampersList(ILoadCallback<List<Codecamper>> pLoadCallback) {

    }

    @Override public void getRoom(int pId, ILoadCallback<Room> pLoadCallback) {

    }

    @Override public void getSession(int pId, ILoadCallback<Session> pLoadCallback) {

    }

    @Override public void getTimeFrame(int pId, ILoadCallback<TimeFrame> pLoadCallback) {

    }

    @Override public void getCodecamper(int pId, ILoadCallback<Codecamper> pLoadCallback) {

    }

    @Override public void setSessionFavorite(int pSessionId, boolean pFavorite, ILoadCallback<Session> pLoadCallback) {

    }
}
