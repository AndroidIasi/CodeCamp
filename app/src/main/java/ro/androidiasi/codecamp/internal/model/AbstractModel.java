package ro.androidiasi.codecamp.internal.model;

/**
 * Created by andrei on 06/04/16.
 */
public abstract class AbstractModel implements IModel {

    private final long mId;

    public AbstractModel(Long pId) {
        mId = pId;
    }

    @Override public final long getId() {
        return mId;
    }
}
