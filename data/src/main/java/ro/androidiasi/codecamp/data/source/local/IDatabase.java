package ro.androidiasi.codecamp.data.source.local;

import com.snappydb.SnappydbException;

import org.androidannotations.annotations.AfterInject;

import java.util.List;

import ro.androidiasi.codecamp.data.model.DataCodecamper;
import ro.androidiasi.codecamp.data.model.DataRoom;
import ro.androidiasi.codecamp.data.model.DataSession;
import ro.androidiasi.codecamp.data.model.DataTimeFrame;

/**
 * Created by andrei on 21/04/16.
 */
public interface IDatabase {

    @AfterInject void afterMembersInject();

    boolean isDataSessionFavorite(Long pDataSessionId) throws SnappydbException;

    void setDataSessionFavorite(Long pLong, boolean pIsFavorite) throws SnappydbException;

    void saveDataRoomsList(List<DataRoom> pDataRoomList);

    List<DataRoom> getDataRooms() throws SnappydbException;

    void deleteDataRooms();

    void saveDataTimeFrames(List<DataTimeFrame> pTimeFrameList);

    List<DataTimeFrame> getDataTimeFrames() throws SnappydbException;

    void deleteDataTimeFrames();

    void saveDataCodecampers(List<DataCodecamper> pCodecamperList);

    List<DataCodecamper> getDataCodecampers() throws SnappydbException;

    void deleteDataCodecampers();

    void saveDataSessions(List<DataSession> pDataSessions);

    List<DataSession> getDataSessions() throws SnappydbException;

    void deleteDataSessions();

    boolean dataRoomsExist();

    boolean dataTimeFramesExist();

    boolean dataCodecampersExist();

    boolean dataSessionsExist();
}
