package ro.androidiasi.codecamp.data.source.remote;

import java.util.List;

import ro.androidiasi.codecamp.data.model.DataCodecamper;
import ro.androidiasi.codecamp.data.model.DataRoom;
import ro.androidiasi.codecamp.data.model.DataSession;
import ro.androidiasi.codecamp.data.model.DataTimeFrame;
import ro.androidiasi.codecamp.data.source.IAgendaDataSource;
import ro.androidiasi.codecamp.data.source.ILoadCallback;

/**
 * Created by andrei on 06/04/16.
 */
public class AgendaRemoteDataSource implements IAgendaDataSource {

    @Override public void getRoomsList(ILoadCallback<List<DataRoom>> pLoadCallback) {

    }

    @Override public void getSessionsList(ILoadCallback<List<DataSession>> pLoadCallback) {

    }

    @Override public void getTimeFramesList(ILoadCallback<List<DataTimeFrame>> pLoadCallback) {

    }

    @Override public void getCodecampersList(ILoadCallback<List<DataCodecamper>> pLoadCallback) {

    }

    @Override public void getRoom(int pId, ILoadCallback<DataRoom> pLoadCallback) {

    }

    @Override public void getSession(int pId, ILoadCallback<DataSession> pLoadCallback) {

    }

    @Override public void getTimeFrame(int pId, ILoadCallback<DataTimeFrame> pLoadCallback) {

    }

    @Override public void getCodecamper(int pId, ILoadCallback<DataCodecamper> pLoadCallback) {

    }

    @Override public void isSessionFavorite(int pSessionId, ILoadCallback<DataSession> pLoadCallback) {

    }

    @Override public void setSessionFavorite(int pSessionId, boolean pFavorite, ILoadCallback<DataSession> pLoadCallback) {

    }
}
