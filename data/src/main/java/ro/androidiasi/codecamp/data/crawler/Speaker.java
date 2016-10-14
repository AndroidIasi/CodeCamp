
package ro.androidiasi.codecamp.data.crawler;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Speaker {

    @JsonProperty("name")
    public String name;
    @JsonProperty("photoUrl")
    public String photoUrl;
    @JsonProperty("company")
    public String company;
    @JsonProperty("companyWebsiteUrl")
    public String companyWebsiteUrl;
    @JsonProperty("jobTitle")
    public String jobTitle;
    @JsonProperty("bio")
    public String bio;
    @JsonProperty("displayOrder")
    public int displayOrder;

}
