package ro.androidiasi.codecamp.data.model;

import java.util.ArrayList;
import java.util.List;

import ro.androidiasi.codecamp.data.crawler.Booking;

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

    public static DataSession fromBooking(Booking pBooking){
        if(pBooking.getSession() == null){
            return allTracksSession(pBooking);
        } else {
            return simpleSession(pBooking);
        }
    }

    public static List<DataSession> fromBookingsList(List<Booking> pBookingList){
        List<DataSession> dataSessionsList = new ArrayList<>();
        for (int i = 0; i < pBookingList.size(); i++) {
            dataSessionsList.add(fromBooking(pBookingList.get(i)));
        }
        return dataSessionsList;
    }

    private static DataSession allTracksSession(Booking pBooking){
        long id = pBooking.getAlt().hashCode();
        List<DataCodecamper> codecampersList = new ArrayList<>();
        DataRoom dataRoom = DataRoom.EVERYWHERE;
        String name = pBooking.getAlt();
        String description = pBooking.getAlt();
        DataTimeFrame dataTimeFrame = DataTimeFrame.fromTimeSlot(pBooking.getTimeSlot());
        return new DataSession(id, codecampersList, dataRoom, name, description, dataTimeFrame);
    }

    private static DataSession simpleSession(Booking pBooking){
        long id = pBooking.getSession().getCode().hashCode();
        List<DataCodecamper> codecampersList = DataCodecamper.fromSpeakersList(pBooking.getSession().getSpeakers());
        DataRoom dataRoom = DataRoom.fromTrack(pBooking.getTrack());
        String name = pBooking.getSession().getTitle();
        String description = pBooking.getSession().getDescription();
        DataTimeFrame dataTimeFrame = DataTimeFrame.fromTimeSlot(pBooking.getTimeSlot());
        return new DataSession(id, codecampersList, dataRoom, name, description, dataTimeFrame);
    }
}
