
package ro.androidiasi.codecamp.data.crawler;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Venue {

    @JsonProperty("name")
    public String name;
    @JsonProperty("city")
    public String city;
    @JsonProperty("country")
    public String country;
    @JsonProperty("directions")
    public String directions;

}
