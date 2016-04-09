package ro.androidiasi.codecamp.data.model;

import java.util.UUID;

/**
 * Created by andrei on 06/04/16.
 */
public abstract class AbstractDataModel implements IDataModel {
    private final int mId;

    public AbstractDataModel(){
        this.mId = UUID.randomUUID().hashCode();
    }

    public AbstractDataModel(int pId) {
        mId = pId;
    }

    @Override public final int getId() {
        return mId;
    }
}
