
package ro.androidiasi.codecamp.data.crawler;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Sponsor {

    @JsonProperty("name")
    public String name;
    @JsonProperty("logoUrl")
    public String logoUrl;
    @JsonProperty("websiteUrl")
    public String websiteUrl;
    @JsonProperty("sponsorshipPackage")
    public String sponsorshipPackage;
    @JsonProperty("displayOrder")
    public int displayOrder;

}
