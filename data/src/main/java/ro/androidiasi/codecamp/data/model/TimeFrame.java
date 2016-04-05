package ro.androidiasi.codecamp.data.model;

import java.util.Date;

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

}