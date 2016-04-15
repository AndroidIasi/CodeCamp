package ro.androidiasi.codecamp.internal.model;

/**
 * Created by andrei on 06/04/16.
 */
public final class Session extends AbstractModel {

    private final Codecamper mCodecamper;
    private final Room mRoom;
    private final String mName;
    private final String mDescription;
    private final TimeFrame mTimeFrame;

    private final boolean mFavorite;

    public Session(Codecamper pCodecamper, Room pRoom, String pName, String pDescription, TimeFrame pTimeFrame, boolean pFavorite) {
        mCodecamper = pCodecamper;
        mRoom = pRoom;
        mName = pName;
        mDescription = pDescription;
        mTimeFrame = pTimeFrame;
        mFavorite = pFavorite;
    }

    public Codecamper getCodecamper() {
        return mCodecamper;
    }

    public Room getRoom() {
        return mRoom;
    }

    public String getName() {
        return mName;
    }

    public String getDescription() {
        return mDescription;
    }

    public TimeFrame getTimeFrame() {
        return mTimeFrame;
    }


    public boolean isFavorite() {
        return mFavorite;
    }

}
