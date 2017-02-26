package ro.androidiasi.codecamp.data.crawler;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Conference {

    @JsonProperty("endDate")
    public String endDate;
    @JsonProperty("refId")
    public Integer refId;
    @JsonProperty("startDate")
    public String startDate;
    @JsonProperty("title")
    public String title;
    @JsonProperty("venue")
    public Venue venue;

}
