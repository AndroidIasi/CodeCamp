package ro.androidiasi.codecamp.data.model;

import java.util.UUID;

/**
 * Created by andrei on 06/04/16.
 */
public abstract class AbstractDataModel implements IDataModel<Long> {
    private long mId;

    public AbstractDataModel(){
        this.mId = UUID.randomUUID().hashCode();
    }

    public AbstractDataModel(Long pId) {
        mId = pId;
    }

    @Override public Long getId() {
        return mId;
    }
}
