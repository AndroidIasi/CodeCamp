package ro.androidiasi.codecamp.internal.model;

import ro.androidiasi.codecamp.data.model.DataRoom;

/**
 * Created by andrei on 06/04/16.
 */
public final class Room extends AbstractModel {

    private final String mName;
    private final int mFloor;
    private final int mSeats;

    public Room(long pId, String pName, int pFloor, int pSeats) {
        super(pId);
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

    public static Room fromDataRoom(DataRoom pDataRoom){
        return new Room(
                pDataRoom.getId(),
                pDataRoom.getName(),
                pDataRoom.getFloor(),
                pDataRoom.getSeats()
        );
    }
}
