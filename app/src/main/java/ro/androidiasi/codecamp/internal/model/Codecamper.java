package ro.androidiasi.codecamp.internal.model;

import java.util.ArrayList;
import java.util.List;

import ro.androidiasi.codecamp.data.model.DataCodecamper;

/**
 * Created by andrei on 06/04/16.
 */
public final class Codecamper extends AbstractModel {

    private final String mFullName;
    private final String mTitle;
    private final String mCompany;
    private final String mDescription;
    private final String mPhotoUrl;

    public Codecamper(long pId, String pFullName, String pTitle, String pCompany, String pDescription, String pPhotoUrl) {
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

    public static Codecamper fromDataCodecamper(DataCodecamper pDataCodecamper){
        return new Codecamper(
                pDataCodecamper.getId(),
                pDataCodecamper.getFullName(),
                pDataCodecamper.getTitle(),
                pDataCodecamper.getCompany(),
                pDataCodecamper.getDescription(),
                pDataCodecamper.getPhotoUrl()
        );
    }

    public static List<Codecamper> fromDataCodecamperList(List<DataCodecamper> pDataCodecampersList){
        List<Codecamper> codecampersList = new ArrayList<>();
        for (int i = 0; i < pDataCodecampersList.size(); i++) {
            Codecamper codecamper = Codecamper.fromDataCodecamper(pDataCodecampersList.get(i));
            codecampersList.add(codecamper);
        }
        return codecampersList;
    }
}
