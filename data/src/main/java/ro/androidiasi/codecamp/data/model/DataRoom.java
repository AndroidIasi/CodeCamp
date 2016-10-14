package ro.androidiasi.codecamp.data.model;

import java.util.ArrayList;
import java.util.List;

import ro.androidiasi.codecamp.data.crawler.Track;

/**
 * Created by andrei on 06/04/16.
 */
public class DataRoom extends AbstractDataModel {

    public static final DataRoom EVERYWHERE = new DataRoom(-1, "-1","","");

    private String mCode;
    private String mName;
    private String mDescription;

    public DataRoom(){

    }

    public DataRoom(long pId, String pCode, String pName, String pDescription) {
        super(pId);
        mCode = pCode;
        mName = pName;
        mDescription = pDescription;
    }

    public String getCode() {
        return mCode;
    }

    public String getDescription() {
        return mDescription;
    }

    public String getName() {
        return mName;
    }

    public static DataRoom fromTrack(Track pTrack){
        return new DataRoom(
                pTrack.name.hashCode(),
                pTrack.name,
                pTrack.name,
                pTrack.description
        );
    }

    public static List<DataRoom> fromTracksList(List<Track> pTracks){
        List<DataRoom> dataRoomsList = new ArrayList<>();
        for (int i = 0; i < pTracks.size(); i++) {
            dataRoomsList.add(fromTrack(pTracks.get(i)));
        }
        return dataRoomsList;
    }
}
