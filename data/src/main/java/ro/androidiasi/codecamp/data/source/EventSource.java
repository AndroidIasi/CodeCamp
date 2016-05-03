package ro.androidiasi.codecamp.data.source;

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
public enum EventSource implements Comparator<EventSource> {

    IASI("2016-04-23T05:00:00.000Z", "iasi.data.min.json", "iasi.index.html"),
    CLUJ("2016-06-07T05:00:00.000Z", "cluj.data.min.json", "cluj.index.html");

    private final Date mEventDate;
    private final String mDataJsonFile;
    private final String mDataHtmlFile;

    EventSource(String pEventDate, String pDataJsonFile, String pDataHtmlFile){
        mEventDate = this.getDateFromString(pEventDate);
        mDataJsonFile = pDataJsonFile;
        mDataHtmlFile = pDataHtmlFile;
    }

    private Date getDateFromString(String pStringDate){
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mmZ");
        try {
            return dateFormat.parse(pStringDate);
        } catch (ParseException pE) {
            pE.printStackTrace();
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

    @Override public int compare(EventSource lhs, EventSource rhs) {
        return rhs.getEventDate().compareTo(lhs.getEventDate());
    }

    public static EventSource getLattestEvent(){
        List<EventSource> list = Arrays.asList(EventSource.values());
        Collections.sort(list);
        return list.get(0);
    }
}
