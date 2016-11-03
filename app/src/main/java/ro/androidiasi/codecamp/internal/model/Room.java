package ro.androidiasi.codecamp.internal.model;

import ro.androidiasi.codecamp.data.model.DataRoom;

/**
 * Created by andrei on 06/04/16.
 */
public final class Room extends AbstractModel {

    private final String mName;
    private String mDescription;

    public Room(long pId, String pName, String pDescription) {
        super(pId);
        mName = pName;
        mDescription = pDescription;
    }

    public String getName() {
        return mName;
    }

    public String getDescription() {
        return mDescription;
    }

    public static Room fromDataRoom(DataRoom pDataRoom) {
        return new Room(
                pDataRoom.getId(),
                pDataRoom.getName(),
                pDataRoom.getDescription()
        );
    }
}
