package ro.androidiasi.codecamp.data.source;

import android.util.Log;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import ro.androidiasi.codecamp.data.crawler.Conference;

/**
 * Created by andrei on 03/05/16.
 */
public class DataConference {

    public static final String CONFERENCE_ID_FORMAT = "conference-%s";
    public static final String CONFERENCE_LOCAL_FILE = "conference-%s.json";
    public static final String CONFERENCES_LIST_LOCAL_FILE = "conferences.json";
    public static final String CONFERENCE_JSON_URL = "https://connect.codecamp.ro/api/conferences/%s";
    public static final String CONFERENCES_LIST_URL = "https://connect.codecamp.ro/api/conferences";

//    IASI("Iasi - Autumn 2016", "2016-10-22T00:00:00", "iasi.data.min.json",
//            "https://connect.codecamp.ro/api/conferences/2"),
//    CLUJ("Cluj - Autumn 2016", "2016-11-19T00:00:00", "cluj.data.min.json",
//            "https://connect.codecamp.ro/api/conferences/3");

    private final String mId;
    private final String mName;
    private final Date mEventDate;
    private final String mDataJsonFile;
    private final String mConnectJsonURL;

    DataConference(String pId, String pName, String pEventDate, String pDataJsonFile, String pConnectJsonURL) {
        mId = pId;
        mName = pName;
        mEventDate = this.getDateFromString(pEventDate);
        mDataJsonFile = pDataJsonFile;
        mConnectJsonURL = pConnectJsonURL;
    }

    private Date getDateFromString(String pStringDate) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        try {
            return dateFormat.parse(pStringDate);
        } catch (ParseException pE) {
            Log.e("DataConference", "getDateFromString: ", pE);
        }
        return new Date();
    }

    public String getDataJsonFile() {
        return mDataJsonFile;
    }

    public String getConnectJsonURL() {
        return mConnectJsonURL;
    }

    public Date getEventDate() {
        return ((Date) mEventDate.clone());
    }

    public String getName() {
        return mName;
    }

    public String getId() {
        return mId;
    }

    public static DataConference getFromString(List<DataConference> conferences, String pValue) {
        if (pValue != null) {
            for (DataConference conference : conferences){
                if (pValue.equals(conference.mId)){
                    return conference;
                }
            }
        }
        return getLatestEvent(conferences);
    }

    public static DataConference getLatestEvent(List<DataConference> conferences) {
        Date today = new Date();
        long conferenceLingerTime = 7L * (24*60*60*1000); // 7 days
        List<DataConference> list = listByDateAscending(conferences);
        for (DataConference conference: list) {
            if (today.getTime() - conference.getEventDate().getTime() < conferenceLingerTime) {
                return conference;
            }
        }
        //Fallback, we have no more conferences in the future
        return list.get(0);
    }

    public static List<DataConference> listByDateAscending(List<DataConference> initial) {
        List<DataConference> list = new ArrayList<>(initial.size());
        for (DataConference conference:initial) { list.add(conference); }
        Collections.sort(list, new Comparator<DataConference>() {
            @Override public int compare(DataConference lhs, DataConference rhs) {
                return lhs.getEventDate().compareTo(rhs.getEventDate());
            }
        });
        return list;
    }

    public static DataConference fromCrawlerConference(Conference crawlerConference) {
        return new DataConference(
                String.format(CONFERENCE_ID_FORMAT, String.valueOf(crawlerConference.refId)),
                crawlerConference.title,
                crawlerConference.startDate,
                String.format(CONFERENCE_LOCAL_FILE, String.valueOf(crawlerConference.refId)),
                String.format(CONFERENCE_JSON_URL, String.valueOf(crawlerConference.refId)));
    }
}
