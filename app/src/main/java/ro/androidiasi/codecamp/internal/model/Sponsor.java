package ro.androidiasi.codecamp.internal.model;

import java.util.ArrayList;
import java.util.List;

import ro.androidiasi.codecamp.data.model.DataSponsor;

/**
 * Created by andrei.
 */

public class Sponsor implements IModel {
    private String mName;
    private String mLogoUrl;
    private String mWebsiteUrl;
    private String mSponsorshipPackage;
    private int mDisplayOrder;
    private int mSponsorshipPackageDisplayOrder;

    public String getName() {
        return mName;
    }

    public void setName(String pName) {
        mName = pName;
    }

    public String getLogoUrl() {
        return mLogoUrl;
    }

    public void setLogoUrl(String pLogoUrl) {
        mLogoUrl = pLogoUrl;
    }

    public String getWebsiteUrl() {
        return mWebsiteUrl;
    }

    public void setWebsiteUrl(String pWebsiteUrl) {
        mWebsiteUrl = pWebsiteUrl;
    }

    public String getSponsorshipPackage() {
        return mSponsorshipPackage;
    }

    public void setSponsorshipPackage(String pSponsorshipPackage) {
        mSponsorshipPackage = pSponsorshipPackage;
    }

    public int getDisplayOrder() {
        return mDisplayOrder;
    }

    public void setDisplayOrder(int pDisplayOrder) {
        mDisplayOrder = pDisplayOrder;
    }

    public int getSponsorshipPackageDisplayOrder() {
        return mSponsorshipPackageDisplayOrder;
    }

    public void setSponsorshipPackageDisplayOrder(int pSponsorshipPackageDisplayOrder) {
        mSponsorshipPackageDisplayOrder = pSponsorshipPackageDisplayOrder;
    }

    public static Sponsor fromDataSponsor(DataSponsor pDataSponsor) {
        Sponsor result = new Sponsor();
        result.setName(pDataSponsor.getName());
        result.setLogoUrl(pDataSponsor.getLogoUrl());
        result.setWebsiteUrl(pDataSponsor.getWebsiteUrl());
        result.setSponsorshipPackage(pDataSponsor.getSponsorshipPackage());
        result.setDisplayOrder(pDataSponsor.getDisplayOrder());
        result.setSponsorshipPackageDisplayOrder(pDataSponsor.getSponsorshipPackageDisplayOrder());
        return result;
    }

    public static List<Sponsor> fromDataSponsorsList(List<DataSponsor> pDataSponsorList) {
        List<Sponsor> result = new ArrayList<>();
        for (int i = 0; pDataSponsorList != null && i < pDataSponsorList.size(); i++) {
            result.add(fromDataSponsor(pDataSponsorList.get(i)));
        }
        return result;
    }

    @Override public long getId() {
        return getName().hashCode();
    }
}
