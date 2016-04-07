package ro.androidiasi.codecamp.data.source;

import android.util.SparseArray;

import org.androidannotations.annotations.EBean;

import java.util.List;

import ro.androidiasi.codecamp.data.model.Codecamper;
import ro.androidiasi.codecamp.data.model.IModel;
import ro.androidiasi.codecamp.data.model.Room;
import ro.androidiasi.codecamp.data.model.Session;
import ro.androidiasi.codecamp.data.model.TimeFrame;
import ro.androidiasi.codecamp.data.source.local.AgendaLocalDataSource;
import ro.androidiasi.codecamp.data.source.remote.AgendaRemoteDataSource;

/**
 * Created by andrei on 06/04/16.
 */
@EBean(scope = EBean.Scope.Singleton)
public class AgendaRepository implements IAgendaDataSource {

    private AgendaLocalDataSource mAgendaLocalDataSource;
    private AgendaRemoteDataSource mAgendaRemoteDataSource;
    private SparseArray<IModel> mCache;

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
