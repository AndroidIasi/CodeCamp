package ro.androidiasi.codecamp.data.website;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Created by andrei on 19/04/16.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Agenda {
    @JsonProperty("tracks")
    public List<Track> getTracks() {
        return this.tracks;
    }

    public void setTracks(List<Track> tracks) {
        this.tracks = tracks;
    }

    List<Track> tracks;

    @JsonProperty("timeSlots")
    public List<TimeSlot> getTimeSlots() {
        return this.timeSlots;
    }

    public void setTimeSlots(List<TimeSlot> timeSlots) {
        this.timeSlots = timeSlots;
    }

    List<TimeSlot> timeSlots;

    @JsonProperty("bookings")
    public List<Booking> getBookings() {
        return this.bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }

    List<Booking> bookings;

}
