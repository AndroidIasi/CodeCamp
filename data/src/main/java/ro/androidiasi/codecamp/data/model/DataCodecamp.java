package ro.androidiasi.codecamp.data.model;

import java.util.List;

import ro.androidiasi.codecamp.data.crawler.Codecamp;

/**
 * Created by andrei on 21/04/16.
 */
public class DataCodecamp extends AbstractDataModel {

    private List<DataRoom> mDataRooms;
    private List<DataTimeFrame> mTimeFrames;
    private List<DataCodecamper> mDataCodecampers;
    private List<DataSession> mDataSessions;

    public DataCodecamp(){

    }

    public DataCodecamp(Long pId, List<DataRoom> pDataRooms, List<DataTimeFrame> pTimeFrames, List<DataCodecamper> pDataCodecampers, List<DataSession> pDataSessions) {
        super(pId);
        mDataRooms = pDataRooms;
        mTimeFrames = pTimeFrames;
        mDataCodecampers = pDataCodecampers;
        mDataSessions = pDataSessions;
    }

    public List<DataRoom> getDataRooms() {
        return mDataRooms;
    }

    public List<DataTimeFrame> getTimeFrames() {
        return mTimeFrames;
    }

    public List<DataCodecamper> getDataCodecampers() {
        return mDataCodecampers;
    }

    public List<DataSession> getDataSessions() {
        return mDataSessions;
    }

    public static DataCodecamp fromCrawlerCodecamp(Codecamp pCodecamp){
        List<DataCodecamper> dataCodecampers = DataCodecamper.fromSpeakersList(pCodecamp.getConference().getSpeakers());
        List<DataRoom> dataRooms = DataRoom.fromTracksList(pCodecamp.getConference().getAgenda().getTracks());
        List<DataTimeFrame> dataTimeFrames = DataTimeFrame.fromTimeSlotsList(pCodecamp.getConference().getAgenda().getTimeSlots());
        List<DataSession> dataSessions = DataSession.fromBookingsList(pCodecamp.getConference().getAgenda().getBookings());

        return new DataCodecamp(-1L, dataRooms, dataTimeFrames, dataCodecampers, dataSessions);
    }
}
