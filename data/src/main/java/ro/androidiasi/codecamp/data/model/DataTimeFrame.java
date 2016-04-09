package ro.androidiasi.codecamp.data.model;

import java.util.Date;

/**
 * Created by andrei on 06/04/16.
 */
public final class DataTimeFrame extends AbstractDataModel {

    private final Date mStartTime;
    private final Date mEndTime;

    public DataTimeFrame(Date pStartTime, Date pEndTime) {
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