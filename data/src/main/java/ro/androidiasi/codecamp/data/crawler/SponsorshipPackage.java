
package ro.androidiasi.codecamp.data.crawler;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SponsorshipPackage {

    @JsonProperty("name")
    public String name;
    @JsonProperty("displayOrder")
    public int displayOrder;

}
