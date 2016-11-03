package ro.androidiasi.codecamp.data.model;

/**
 * Created by andrei on 06/04/16.
 */
public abstract class AbstractDataModel implements IDataModel<Long> {
    private long mId;

    public AbstractDataModel(Long pId) {
        mId = pId;
    }

    public AbstractDataModel() {
        this.mId = -1L;
    }

    @Override public Long getId() {
        return mId;
    }

    @Override public void setId(Long pId) {
        mId = pId;
    }
}
