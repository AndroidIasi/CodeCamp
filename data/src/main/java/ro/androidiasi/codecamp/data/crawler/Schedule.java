
package ro.androidiasi.codecamp.data.crawler;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class Schedule {

    @JsonProperty("date")
    public String date;
    @JsonProperty("timeSlots")
    public List<TimeSlot> timeSlots = new ArrayList<TimeSlot>();
    @JsonProperty("tracks")
    public List<Track> tracks = new ArrayList<Track>();
    @JsonProperty("sessions")
    public List<Session> sessions = new ArrayList<Session>();

}
