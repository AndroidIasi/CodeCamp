package ro.androidiasi.codecamp.data.model;

/**
 * Created by andrei on 06/04/16.
 */
public class DataCodecamper extends AbstractDataModel {

    private String mFullName;
    private String mTitle;
    private String mCompany;
    private String mDescription;
    private String mPhotoUrl;

    public DataCodecamper() {
    }

    public DataCodecamper(String pFullName, String pTitle, String pCompany, String pDescription, String pPhotoUrl) {
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
