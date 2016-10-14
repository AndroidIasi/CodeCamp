
package ro.androidiasi.codecamp.data.crawler;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class CodecampNew {

    @JsonProperty("refId")
    public int refId;
    @JsonProperty("title")
    public String title;
    @JsonProperty("startDate")
    public String startDate;
    @JsonProperty("endDate")
    public String endDate;
    @JsonProperty("venue")
    public Venue venue;
    @JsonProperty("sponsorshipPackages")
    public List<SponsorshipPackage> sponsorshipPackages = new ArrayList<SponsorshipPackage>();
    @JsonProperty("sponsors")
    public List<Sponsor> sponsors = new ArrayList<Sponsor>();
    @JsonProperty("schedules")
    public List<Schedule> schedules = new ArrayList<Schedule>();
    @JsonProperty("speakers")
    public List<Speaker> speakers = new ArrayList<Speaker>();

}
