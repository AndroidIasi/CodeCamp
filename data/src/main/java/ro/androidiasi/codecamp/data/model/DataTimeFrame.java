package ro.androidiasi.codecamp.data.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ro.androidiasi.codecamp.data.crawler.TimeSlot;

/**
 * Created by andrei on 06/04/16.
 */
public class DataTimeFrame extends AbstractDataModel {

    private String mName;
    private Date mStartTime;
    private Date mEndTime;


    public DataTimeFrame(long pId, String pName, Date pStartTime, Date pEndTime) {
        super(pId);
        mName = pName;
        mStartTime = pStartTime;
        mEndTime = pEndTime;
    }

    public String getName() {
        return mName;
    }

    public Date getStartTime() {
        return mStartTime;
    }

    public Date getEndTime() {
        return mEndTime;
    }

    public static DataTimeFrame fromTimeSlot(TimeSlot pTimeSlot){
        return new DataTimeFrame(
                pTimeSlot.getCode().hashCode(),
                pTimeSlot.getCode(),
                pTimeSlot.getStart(),
                pTimeSlot.getEnd()
        );
    }

    public static List<DataTimeFrame> fromTimeSlotsList(List<TimeSlot> pTimeSlotList){
        List<DataTimeFrame> dataTimeFramesList = new ArrayList<>();
        for (int i = 0; i < pTimeSlotList.size(); i++) {
            dataTimeFramesList.add(fromTimeSlot(pTimeSlotList.get(i)));
        }
        return dataTimeFramesList;
    }

}