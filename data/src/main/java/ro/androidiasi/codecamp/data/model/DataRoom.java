package ro.androidiasi.codecamp.data.model;

/**
 * Created by andrei on 06/04/16.
 */
public final class DataRoom extends AbstractDataModel {

    private final String mName;
    private final int mFloor;
    private final int mSeats;

    public DataRoom(String pName, int pFloor, int pSeats) {
        mName = pName;
        mFloor = pFloor;
        mSeats = pSeats;
    }

    public int getFloor() {
        return mFloor;
    }

    public int getSeats() {
        return mSeats;
    }

    public String getName() {
        return mName;
    }
}
