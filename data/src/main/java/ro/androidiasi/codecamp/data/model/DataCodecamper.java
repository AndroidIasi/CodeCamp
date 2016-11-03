package ro.androidiasi.codecamp.data.model;

import java.util.ArrayList;
import java.util.List;

import ro.androidiasi.codecamp.data.crawler.Speaker;

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

    public DataCodecamper(long pId, String pFullName, String pTitle, String pCompany, String pDescription, String pPhotoUrl) {
        super(pId);
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

    public static DataCodecamper fromSpeaker(Speaker pSpeaker) {
        return new DataCodecamper(
                pSpeaker.photoUrl.hashCode(),//nasty workaround, doesn't have a reliable ID
                pSpeaker.name,
                pSpeaker.jobTitle,
                pSpeaker.company,
                pSpeaker.bio,
                pSpeaker.photoUrl.replaceAll(" ", "%20")
        );
    }

    public static List<DataCodecamper> fromSpeakersList(List<Speaker> pSpeakers) {
        List<DataCodecamper> dataCodecamperList = new ArrayList<>();
        for (int i = 0; i < pSpeakers.size(); i++) {
            dataCodecamperList.add(fromSpeaker(pSpeakers.get(i)));
        }
        return dataCodecamperList;
    }
}
