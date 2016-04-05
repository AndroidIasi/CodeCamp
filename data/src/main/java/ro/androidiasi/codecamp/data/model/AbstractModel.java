package ro.androidiasi.codecamp.data.model;

import java.util.UUID;

/**
 * Created by andrei on 06/04/16.
 */
public abstract class AbstractModel implements IModel {
    private final int mId;

    public AbstractModel(){
        this.mId = UUID.randomUUID().hashCode();
    }

    public AbstractModel(int pId) {
        mId = pId;
    }

    @Override public final int getId() {
        return mId;
    }
}
