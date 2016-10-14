
package ro.androidiasi.codecamp.data.crawler;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TimeSlot {

    @JsonProperty("startTime")
    public String startTime;
    @JsonProperty("endTime")
    public String endTime;

}
