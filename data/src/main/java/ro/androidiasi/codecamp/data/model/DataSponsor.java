package ro.androidiasi.codecamp.data.model;

import java.util.ArrayList;
import java.util.List;

import ro.androidiasi.codecamp.data.crawler.Sponsor;
import ro.androidiasi.codecamp.data.crawler.SponsorshipPackage;

/**
 * Created by andrei.
 */

public class DataSponsor extends AbstractDataModel {
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

    public static DataSponsor fromSponsor(Sponsor pSponsor, SponsorshipPackage pSponsorshipPackage){
        DataSponsor result = new DataSponsor();
        result.setName(pSponsor.name);
        result.setLogoUrl(pSponsor.logoUrl);
        result.setWebsiteUrl(pSponsor.websiteUrl);
        result.setSponsorshipPackage(pSponsor.sponsorshipPackage);
        result.setDisplayOrder(pSponsor.displayOrder);
        result.setSponsorshipPackageDisplayOrder(pSponsorshipPackage.displayOrder);
        return result;
    }

    public static List<DataSponsor> fromSponsorsList(List<Sponsor> pSponsorList,
                                                     List<SponsorshipPackage> pSponsorshipPackageList){
        List<DataSponsor> result = new ArrayList<>();
        for (int i = 0; pSponsorList!= null && i < pSponsorList.size(); i++) {
            SponsorshipPackage sponsorshipPackageForSponsor =
                    getSponsorshipPackageForSponsor(pSponsorList.get(i), pSponsorshipPackageList);
            result.add(fromSponsor(pSponsorList.get(i), sponsorshipPackageForSponsor));
        }
        return result;
    }

    private static SponsorshipPackage getSponsorshipPackageForSponsor(Sponsor pSponsor,
                                                                      List<SponsorshipPackage> pSponsorshipPackageList){
        for (int i = 0; i < pSponsorshipPackageList.size(); i++) {
            if(pSponsor.sponsorshipPackage.equals(pSponsorshipPackageList.get(i).name)){
                return pSponsorshipPackageList.get(i);
            }
        }
        return new SponsorshipPackage();
    }
}
