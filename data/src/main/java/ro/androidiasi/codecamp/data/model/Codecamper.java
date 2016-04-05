package ro.androidiasi.codecamp.data.model;

/**
 * Created by andrei on 06/04/16.
 */
public final class Codecamper extends AbstractModel{

    private final String mFullName;
    private final String mTitle;
    private final String mCompany;
    private final String mDescription;
    private final String mPhotoUrl;

    public Codecamper(String pFullName, String pTitle, String pCompany, String pDescription, String pPhotoUrl) {
        mFullName = pFullName;
        mTitle = pTitle;
        mCompany = pCompany;
        mDescription = pDescription;
        mPhotoUrl = pPhotoUrl;
    }

    public String getFullName() {
        return mFullName;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getCompany() {
        return mCompany;
    }

    public String getDescription() {
        return mDescription;
    }

    public String getPhotoUrl() {
        return mPhotoUrl;
    }
}
