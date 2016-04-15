package ro.androidiasi.codecamp.data.model;

import java.util.Date;

/**
 * Created by andrei on 06/04/16.
 */
public class DataTimeFrame extends AbstractDataModel {

    private String mName;
    private Date mStartTime;
    private Date mEndTime;


    public DataTimeFrame() {
    }

    public DataTimeFrame(String pName, Date pStartTime, Date pEndTime) {
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

}