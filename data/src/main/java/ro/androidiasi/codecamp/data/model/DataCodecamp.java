package ro.androidiasi.codecamp.data.model;

import java.util.List;

import ro.androidiasi.codecamp.data.crawler.CodecampNew;

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

    public static DataCodecamp fromCrawlerCodecamp(CodecampNew pCodecamp){
        List<DataCodecamper> dataCodecampers = DataCodecamper.fromSpeakersList(pCodecamp.speakers);
        List<DataRoom> dataRooms = DataRoom.fromTracksList(pCodecamp.schedules.get(0).tracks);
        List<DataTimeFrame> dataTimeFrames = DataTimeFrame.fromTimeSlotsList(pCodecamp.schedules.get(0).timeSlots);
        List<DataSession> dataSessions = DataSession.fromSessionList(pCodecamp.schedules.get(0).sessions,
                dataCodecampers, dataRooms, dataTimeFrames);

        return new DataCodecamp(-1L, dataRooms, dataTimeFrames, dataCodecampers, dataSessions);
    }
}
