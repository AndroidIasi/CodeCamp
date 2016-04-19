package ro.androidiasi.codecamp.data.website;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

/**
 * Created by andrei on 19/04/16.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class TimeSlot {
    @JsonProperty("code")
    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    String code;

    @JsonProperty("start")
    public Date getStart() {
        return this.start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    Date start;

    @JsonProperty("end")
    public Date getEnd() {
        return this.end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    Date end;

    @JsonProperty("displayTracks")
    public boolean getDisplayTracks() {
        return this.displayTracks;
    }

    public void setDisplayTracks(boolean displayTracks) {
        this.displayTracks = displayTracks;
    }

    boolean displayTracks;

}

