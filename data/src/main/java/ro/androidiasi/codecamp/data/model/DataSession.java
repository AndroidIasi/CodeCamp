package ro.androidiasi.codecamp.data.model;

/**
 * Created by andrei on 06/04/16.
 */
public final class DataSession extends AbstractDataModel {

    private final String mName;
    private final String mDescription;

    private final DataCodecamper mDataCodecamper;
    private final DataRoom mDataRoom;
    private final DataTimeFrame mDataTimeFrame;

    private boolean mFavorite;

    public DataSession(DataCodecamper pDataCodecamper, DataRoom pDataRoom, String pName, String pDescription, DataTimeFrame pDataTimeFrame) {
        mDataCodecamper = pDataCodecamper;
        mDataRoom = pDataRoom;
        mName = pName;
        mDescription = pDescription;
        mDataTimeFrame = pDataTimeFrame;
    }

    public DataCodecamper getDataCodecamper() {
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
}
