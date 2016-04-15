package ro.androidiasi.codecamp.data.model;

/**
 * Created by andrei on 06/04/16.
 */
public class DataRoom extends AbstractDataModel {

    private String mName;
    private int mFloor;
    private int mSeats;

    public DataRoom() {
    }

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
