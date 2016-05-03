package ro.androidiasi.codecamp.data.source;

import android.util.Log;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

/**
 * Created by andrei on 03/05/16.
 */
public enum EventSource {

    IASI("2016-04-23T05:00:00.000", "iasi.data.min.json", "iasi.index.html", "http://iasi.codecamp.ro/images/speakers/"),
    CLUJ("2016-06-07T05:00:00.000", "cluj.data.min.json", "cluj.index.html", "http://cluj.codecamp.ro/images/speakers/");

    private final Date mEventDate;
    private final String mDataJsonFile;
    private final String mDataHtmlFile;
    private final String mPhotosRootUrl;

    EventSource(String pEventDate, String pDataJsonFile, String pDataHtmlFile, String pPhotosRootUrl){
        mPhotosRootUrl = pPhotosRootUrl;
        mEventDate = this.getDateFromString(pEventDate);
        mDataJsonFile = pDataJsonFile;
        mDataHtmlFile = pDataHtmlFile;
    }

    private Date getDateFromString(String pStringDate){
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
        try {
            return dateFormat.parse(pStringDate);
        } catch (ParseException pE) {
            Log.e("EventSource", "getDateFromString: ", pE);
        }
        return new Date();
    }

    public String getDataJsonFile() {
        return mDataJsonFile;
    }

    public String getDataHtmlFile() {
        return mDataHtmlFile;
    }

    public Date getEventDate() {
        return mEventDate;
    }

    public String getPhotosRootUrl() {
        return mPhotosRootUrl;
    }

    public static EventSource getLatestEvent(){
        List<EventSource> list = Arrays.asList(EventSource.values());
        Collections.sort(list, new Comparator<EventSource>() {
            @Override public int compare(EventSource lhs, EventSource rhs) {
                return rhs.getEventDate().compareTo(lhs.getEventDate());
            }
        });
        return list.get(0);
    }
}
