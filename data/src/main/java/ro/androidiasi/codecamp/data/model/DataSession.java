package ro.androidiasi.codecamp.data.model;

import java.util.ArrayList;
import java.util.List;

import ro.androidiasi.codecamp.data.crawler.Session;

/**
 * Created by andrei on 06/04/16.
 */
public class DataSession extends AbstractDataModel {

    private String mName;
    private String mDescription;

    private List<DataCodecamper> mDataCodecamper;
    private DataRoom mDataRoom;
    private DataTimeFrame mDataTimeFrame;

    private boolean mFavorite;

    public DataSession(){

    }

    public DataSession(long pId, List<DataCodecamper> pDataCodecamper, DataRoom pDataRoom, String pName, String pDescription, DataTimeFrame pDataTimeFrame) {
        super(pId);
        mDataCodecamper = pDataCodecamper;
        mDataRoom = pDataRoom;
        mName = pName;
        mDescription = pDescription;
        mDataTimeFrame = pDataTimeFrame;
    }

    public List<DataCodecamper> getDataCodecampersList() {
        return mDataCodecamper;
    }

    public DataRoom getDataRoom() {
        return mDataRoom;
    }

    public String getName() {
        return mName;
    }

    public String getDescription() {
        return mDescription;
    }

    public DataTimeFrame getDataTimeFrame() {
        return mDataTimeFrame;
    }


    public boolean isFavorite() {
        return mFavorite;
    }

    public void setFavorite(boolean pFavorite) {
        mFavorite = pFavorite;
    }

    public static List<DataSession> fromSessionList(List<Session> sessions, List<DataCodecamper> dataCodecampers, List<DataRoom> dataRooms, List<DataTimeFrame> dataTimeFrames) {
        List<DataSession> dataSessionsList = new ArrayList<>();
        for (Session session : sessions) {

            long id = (session.startTime + session.track).hashCode();
            String name = session.title;
            String description = session.description;
            List<DataCodecamper> codecampers = pickCodecampers(session, dataCodecampers);
            DataRoom dataRoom = pickRoom(session, dataRooms);
            DataTimeFrame timeFrame = pickTimeFrame(session, dataTimeFrames);

            dataSessionsList.add(new DataSession(id, codecampers, dataRoom, name, description, timeFrame));
        }
        return dataSessionsList;
    }

    private static List<DataCodecamper> pickCodecampers(Session session, List<DataCodecamper> dataCodecampers) {
        List<DataCodecamper> sessionCodecampers = new ArrayList<>();
        if (!session.allTracks) {
            for (String speaker : session.speakers) {
                for (DataCodecamper codecamper : dataCodecampers) {
                    if (speaker.equals(codecamper.getFullName())) {
                        sessionCodecampers.add(codecamper);
                    }
                }
            }
        }
        return sessionCodecampers;
    }

    private static DataRoom pickRoom(Session session, List<DataRoom> dataRooms) {
        if (session.allTracks) {
            return DataRoom.EVERYWHERE;
        }

        DataRoom sessionDataRoom = null;
        for (DataRoom dataRoom : dataRooms) {
            if (session.track.equals(dataRoom.getName())) {
                sessionDataRoom = dataRoom;
                break;
            }
        }
        //Should not happen, this is a fallback
        if (sessionDataRoom == null) {
            sessionDataRoom = new DataRoom(session.track.hashCode(), session.track, session.track, session.track);
        }

        return sessionDataRoom;
    }

    private static DataTimeFrame pickTimeFrame(Session session, List<DataTimeFrame> dataTimeFrames) {
        DataTimeFrame sessionDataTimeFrame = null;
        for (DataTimeFrame dataTimeFrame : dataTimeFrames) {
            if (session.startTime.equals(dataTimeFrame.getStartTime()) &&
                    session.endTime.equals(dataTimeFrame.getEndTime())) {
                sessionDataTimeFrame = dataTimeFrame;
                break;
            }
        }
        //Should not happen, this is a fallback
        if (sessionDataTimeFrame == null) {
            sessionDataTimeFrame = new DataTimeFrame(session.startTime.hashCode(), session.startTime, session.startTime, session.endTime);
        }
        return sessionDataTimeFrame;
    }

}
