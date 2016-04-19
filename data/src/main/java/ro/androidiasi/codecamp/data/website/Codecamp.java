package ro.androidiasi.codecamp.data.website;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by andrei on 19/04/16.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Codecamp {
    @JsonProperty("showSpeakers")
    public boolean getShowSpeakers() {
        return this.showSpeakers;
    }

    public void setShowSpeakers(boolean showSpeakers) {
        this.showSpeakers = showSpeakers;
    }

    boolean showSpeakers;

    @JsonProperty("showAgenda")
    public boolean getShowAgenda() {
        return this.showAgenda;
    }

    public void setShowAgenda(boolean showAgenda) {
        this.showAgenda = showAgenda;
    }

    boolean showAgenda;

    @JsonProperty("showRegistration")
    public boolean getShowRegistration() {
        return this.showRegistration;
    }

    public void setShowRegistration(boolean showRegistration) {
        this.showRegistration = showRegistration;
    }

    boolean showRegistration;

    @JsonProperty("showCallForSpeakers")
    public boolean getShowCallForSpeakers() {
        return this.showCallForSpeakers;
    }

    public void setShowCallForSpeakers(boolean showCallForSpeakers) {
        this.showCallForSpeakers = showCallForSpeakers;
    }

    boolean showCallForSpeakers;

    @JsonProperty("showCallForSponsors")
    public boolean getShowCallForSponsors() {
        return this.showCallForSponsors;
    }

    public void setShowCallForSponsors(boolean showCallForSponsors) {
        this.showCallForSponsors = showCallForSponsors;
    }

    boolean showCallForSponsors;

    @JsonProperty("conference")
    public Conference getConference() {
        return this.conference;
    }

    public void setConference(Conference conference) {
        this.conference = conference;
    }

    Conference conference;

    @JsonProperty("showRegister")
    public boolean getShowRegister() {
        return this.showRegister;
    }

    public void setShowRegister(boolean showRegister) {
        this.showRegister = showRegister;
    }

    boolean showRegister;

    @JsonProperty("showSponsors")
    public boolean getShowSponsors() {
        return this.showSponsors;
    }

    public void setShowSponsors(boolean showSponsors) {
        this.showSponsors = showSponsors;
    }

    boolean showSponsors;

}
