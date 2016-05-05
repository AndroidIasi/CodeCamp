package ro.androidiasi.codecamp.data.source.local;

import com.snappydb.SnappydbException;

import java.util.List;

import ro.androidiasi.codecamp.data.model.DataCodecamper;
import ro.androidiasi.codecamp.data.model.DataRoom;
import ro.androidiasi.codecamp.data.model.DataSession;
import ro.androidiasi.codecamp.data.model.DataTimeFrame;
import ro.androidiasi.codecamp.data.source.DataConference;

/**
 * Created by andrei on 21/04/16.
 */
public interface IDatabase {

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

    void setEventSource(DataConference pConference);

}
