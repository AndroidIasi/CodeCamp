package ro.androidiasi.codecamp.internal.model;

/**
 * Created by andrei on 06/04/16.
 */
public final class Room extends AbstractModel {

    private final String mName;
    private final int mFloor;
    private final int mSeats;

    public Room(String pName, int pFloor, int pSeats) {
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
