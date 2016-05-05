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
public enum DataConference {

    IASI("Iasi - 23 April 2016", "2016-04-23T05:00:00.000", "iasi.data.min.json",
            "iasi.index.html", "http://iasi.codecamp.ro/images/speakers/"),
    CLUJ("Cluj - 07 May 2016", "2016-06-07T05:00:00.000", "cluj.data.min.json",
            "cluj.index.html", "http://cluj.codecamp.ro/images/speakers/");

    private final String mName;
    private final Date mEventDate;
    private final String mDataJsonFile;
    private final String mDataHtmlFile;
    private final String mPhotosRootUrl;

    DataConference(String pName, String pEventDate, String pDataJsonFile, String pDataHtmlFile, String pPhotosRootUrl){
        mName = pName;
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
            Log.e("DataConference", "getDateFromString: ", pE);
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

    public String getName() {
        return mName;
    }

    public static DataConference getFromString(String pValue){
        if(pValue != null) {
            for (int i = 0; i < DataConference.values().length; i++) {
                if (pValue.toUpperCase().equals(DataConference.values()[i].toString())) {
                    return DataConference.values()[i];
                }
            }
        }
        return getLatestEvent();
    }

    public static DataConference getLatestEvent(){
        List<DataConference> list = listByDate();
        return list.get(0);
    }

    public static List<DataConference> listByDate(){
        List<DataConference> list = Arrays.asList(DataConference.values());
        Collections.sort(list, new Comparator<DataConference>() {
            @Override public int compare(DataConference lhs, DataConference rhs) {
                return rhs.getEventDate().compareTo(lhs.getEventDate());
            }
        });
        return list;
    }
}
