package ro.androidiasi.codecamp.internal.model;

import java.util.ArrayList;
import java.util.List;

import ro.androidiasi.codecamp.data.source.DataConference;

/**
 * Created by andrei on 05/05/16.
 */
public class Conference extends AbstractModel {

    private String mStringId;
    private String mName;

    public Conference(long pId, String pStringId, String pName) {
        super(pId);
        this.mStringId = pStringId;
        this.mName = pName;
    }

    public String getName() {
        return mName;
    }

    public String getStringId() {
        return mStringId;
    }

    public static Conference fromDataConference(DataConference pDataConference) {
        return new Conference(
                pDataConference.toString().hashCode(),
                pDataConference.toString(),
                pDataConference.getName());
    }

    public static List<Conference> fromDataConferenceList(List<DataConference>
                                                                  pDataConferenceList) {
        List<Conference> conferenceList = new ArrayList<>();
        for (int i = 0; i < pDataConferenceList.size(); i++) {
            conferenceList.add(fromDataConference(pDataConferenceList.get(i)));
        }
        return conferenceList;
    }
}
