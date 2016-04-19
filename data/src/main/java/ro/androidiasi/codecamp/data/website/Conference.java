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
public class Conference {
    @JsonProperty("title")
    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    String title;

    @JsonProperty("speakers")
    public List<Speaker> getSpeakers() {
        return this.speakers;
    }

    public void setSpeakers(List<Speaker> speakers) {
        this.speakers = speakers;
    }

    List<Speaker> speakers;

    @JsonProperty("sessions")
    public List<Session> getSessions() {
        return this.sessions;
    }

    public void setSessions(List<Session> sessions) {
        this.sessions = sessions;
    }

    List<Session> sessions;

    @JsonProperty("agenda")
    public Agenda getAgenda() {
        return this.agenda;
    }

    public void setAgenda(Agenda agenda) {
        this.agenda = agenda;
    }

    Agenda agenda;

}
