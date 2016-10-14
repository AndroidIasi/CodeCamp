
package ro.androidiasi.codecamp.data.crawler;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;


public class Session {

    @JsonProperty("startTime")
    public String startTime;
    @JsonProperty("endTime")
    public String endTime;
    @JsonProperty("allTracks")
    public boolean allTracks;
    @JsonProperty("track")
    public String track;
    @JsonProperty("title")
    public String title;
    @JsonProperty("description")
    public String description;
    @JsonProperty("speakers")
    public List<String> speakers;
    @JsonProperty("speakingLang")
    public Object speakingLang;
    @JsonProperty("level")
    public Object level;

}
