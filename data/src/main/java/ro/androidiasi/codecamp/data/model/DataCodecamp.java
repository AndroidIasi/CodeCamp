package ro.androidiasi.codecamp.data.model;

import java.util.ArrayList;
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
    private List<DataSponsor> mDataSponsors;

    public DataCodecamp() {

    }

    public DataCodecamp(Long pId, List<DataRoom> pDataRooms, List<DataTimeFrame> pTimeFrames,
                        List<DataCodecamper> pDataCodecampers, List<DataSession> pDataSessions,
                        List<DataSponsor> pDataSponsorList) {
        super(pId);
        mDataRooms = pDataRooms;
        mTimeFrames = pTimeFrames;
        mDataCodecampers = pDataCodecampers;
        mDataSessions = pDataSessions;
        mDataSponsors = pDataSponsorList;
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

    public List<DataSponsor> getDataSponsors() {
        return mDataSponsors;
    }

    public static DataCodecamp fromCrawlerCodecamp(CodecampNew pCodecamp) {
        List<DataCodecamper> dataCodecampers = DataCodecamper.fromSpeakersList(pCodecamp.speakers);
        List<DataRoom> dataRooms;
        List<DataTimeFrame> dataTimeFrames;
        List<DataSession> dataSessions;
        if (pCodecamp.schedules.isEmpty()){
            dataRooms = new ArrayList<>();
            dataTimeFrames = new ArrayList<>();
            dataSessions = new ArrayList<>();
        } else {
            dataRooms = DataRoom.fromTracksList(pCodecamp.schedules.get(0).tracks);
            dataTimeFrames = DataTimeFrame.fromTimeSlotsList(pCodecamp.schedules.get(0).timeSlots);
            dataSessions = DataSession.fromSessionList(pCodecamp.schedules.get(0).sessions,
                    dataCodecampers, dataRooms, dataTimeFrames);
        }
        List<DataSponsor> dataSponsorList = DataSponsor.fromSponsorsList(pCodecamp.sponsors, pCodecamp.sponsorshipPackages);
        return new DataCodecamp(-1L, dataRooms, dataTimeFrames, dataCodecampers, dataSessions, dataSponsorList);
    }
}
