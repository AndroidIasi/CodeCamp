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

    IASI("Iasi - Autumn 2016", "2016-10-22T00:00:00", "iasi.data.min.json",
            "https://connect.codecamp.ro/api/conferences/2"),
    CLUJ("Cluj - Autumn 2016", "2016-11-19T00:00:00", "cluj.data.min.json",
            "https://connect.codecamp.ro/api/conferences/3");

    private final String mName;
    private final Date mEventDate;
    private final String mDataJsonFile;
    private final String mConnectJsonURL;

    DataConference(String pName, String pEventDate, String pDataJsonFile, String pConnectJsonURL){
        mName = pName;
        mEventDate = this.getDateFromString(pEventDate);
        mDataJsonFile = pDataJsonFile;
        mConnectJsonURL = pConnectJsonURL;
    }

    private Date getDateFromString(String pStringDate){
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
        return mEventDate;
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
        Date today = new Date();
        long conferenceLingerTime = 7L * (24*60*60*1000); // 7 days
        List<DataConference> list = listByDateAscending();
        for (DataConference conference: list){
            if (today.getTime() - conference.getEventDate().getTime() < conferenceLingerTime){
                return conference;
            }
        }
        //Fallback, we have no more conferences in the future
        return list.get(0);
    }

    public static List<DataConference> listByDateAscending(){
        List<DataConference> list = Arrays.asList(DataConference.values());
        Collections.sort(list, new Comparator<DataConference>() {
            @Override public int compare(DataConference lhs, DataConference rhs) {
                return lhs.getEventDate().compareTo(rhs.getEventDate());
            }
        });
        return list;
    }
}
