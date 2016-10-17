package ro.androidiasi.codecamp.internal.model;

import java.util.ArrayList;
import java.util.List;

import ro.androidiasi.codecamp.data.model.DataSponsor;

/**
 * Created by andrei.
 */

public class Sponsor implements IModel{
    private String name;
    private String logoUrl;
    private String websiteUrl;
    private String sponsorshipPackage;
    private int displayOrder;
    private int sponsorshipPackageDisplayOrder;

    public String getName() {
        return name;
    }

    public void setName(String pName) {
        name = pName;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String pLogoUrl) {
        logoUrl = pLogoUrl;
    }

    public String getWebsiteUrl() {
        return websiteUrl;
    }

    public void setWebsiteUrl(String pWebsiteUrl) {
        websiteUrl = pWebsiteUrl;
    }

    public String getSponsorshipPackage() {
        return sponsorshipPackage;
    }

    public void setSponsorshipPackage(String pSponsorshipPackage) {
        sponsorshipPackage = pSponsorshipPackage;
    }

    public int getDisplayOrder() {
        return displayOrder;
    }

    public void setDisplayOrder(int pDisplayOrder) {
        displayOrder = pDisplayOrder;
    }

    public int getSponsorshipPackageDisplayOrder() {
        return sponsorshipPackageDisplayOrder;
    }

    public void setSponsorshipPackageDisplayOrder(int pSponsorshipPackageDisplayOrder) {
        sponsorshipPackageDisplayOrder = pSponsorshipPackageDisplayOrder;
    }

    public static Sponsor fromDataSponsor(DataSponsor pDataSponsor){
        Sponsor result = new Sponsor();
        result.setName(pDataSponsor.getName());
        result.setLogoUrl(pDataSponsor.getLogoUrl());
        result.setWebsiteUrl(pDataSponsor.getWebsiteUrl());
        result.setSponsorshipPackage(pDataSponsor.getSponsorshipPackage());
        result.setDisplayOrder(pDataSponsor.getDisplayOrder());
        result.setSponsorshipPackageDisplayOrder(pDataSponsor.getSponsorshipPackageDisplayOrder());
        return result;
    }

    public static List<Sponsor> fromDataSponsorsList(List<DataSponsor> pDataSponsorList){
        List<Sponsor> result = new ArrayList<>();
        for (int i = 0; pDataSponsorList!= null && i < pDataSponsorList.size(); i++) {
            result.add(fromDataSponsor(pDataSponsorList.get(i)));
        }
        return result;
    }

    @Override public long getId() {
        return getName().hashCode();
    }
}
