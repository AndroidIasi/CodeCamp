package ro.androidiasi.codecamp.internal.model;

import java.util.Date;

import ro.androidiasi.codecamp.data.model.DataTimeFrame;

/**
 * Created by andrei on 06/04/16.
 */
public final class TimeFrame extends AbstractModel {

    private final Date mStartTime;
    private final Date mEndTime;

    public TimeFrame(Date pStartTime, Date pEndTime) {
        mStartTime = pStartTime;
        mEndTime = pEndTime;
    }

    public Date getStartTime() {
        return mStartTime;
    }

    public Date getEndTime() {
        return mEndTime;
    }

    public static TimeFrame fromDataTimeFrame(DataTimeFrame pDataTimeFrame){
        return new TimeFrame(
                pDataTimeFrame.getStartTime(),
                pDataTimeFrame.getEndTime()
        );
    }
}