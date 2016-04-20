package ro.androidiasi.codecamp.data.crawler;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by andrei on 19/04/16.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Booking {
    @JsonProperty("timeSlot")
    public TimeSlot getTimeSlot() {
        return this.timeSlot;
    }

    public void setTimeSlot(TimeSlot timeSlot) {
        this.timeSlot = timeSlot;
    }

    TimeSlot timeSlot;

    @JsonProperty("track")
    public Track getTrack() {
        return this.track;
    }

    public void setTrack(Track track) {
        this.track = track;
    }

    Track track;

    @JsonProperty("session")
    public Session getSession() {
        return this.session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    Session session;

    @JsonProperty("alt")
    public String getAlt() {
        return this.alt;
    }

    public void setAlt(String alt) {
        this.alt = alt;
    }

    String alt;

}
