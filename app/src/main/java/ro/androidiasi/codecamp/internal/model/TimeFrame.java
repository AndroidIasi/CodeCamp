package ro.androidiasi.codecamp.internal.model;

import ro.androidiasi.codecamp.data.model.DataTimeFrame;

/**
 * Created by andrei on 06/04/16.
 */
public final class TimeFrame extends AbstractModel {

    private final String mStartTime;
    private final String mEndTime;

    public TimeFrame(long pId, String pStartTime, String pEndTime) {
        super(pId);
        mStartTime = pStartTime;
        mEndTime = pEndTime;
    }

    public String getStartTime() {
        return mStartTime;
    }

    public String getEndTime() {
        return mEndTime;
    }

    public static TimeFrame fromDataTimeFrame(DataTimeFrame pDataTimeFrame) {
        return new TimeFrame(
                pDataTimeFrame.getId(),
                pDataTimeFrame.getStartTime(),
                pDataTimeFrame.getEndTime()
        );
    }
}