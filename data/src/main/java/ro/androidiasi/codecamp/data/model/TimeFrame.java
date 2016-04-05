package ro.androidiasi.codecamp.data.model;

import java.util.Date;

/**
 * Created by andrei on 06/04/16.
 */
public class TimeFrame implements IModel {

    private Date mStartTime;
    private Date mEndTime;

    public TimeFrame(Date pStartTime, Date pEndTime) {
        mStartTime = pStartTime;
        mEndTime = pEndTime;
    }

    public Date getStartTime() {
        return mStartTime;
    }

    public void setStartTime(Date pStartTime) {
        mStartTime = pStartTime;
    }

    public Date getEndTime() {
        return mEndTime;
    }

    public void setEndTime(Date pEndTime) {
        mEndTime = pEndTime;
    }
}
