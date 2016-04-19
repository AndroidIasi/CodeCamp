package ro.androidiasi.codecamp.data.source.remote;

import android.content.Context;
import android.util.Log;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;
import org.androidannotations.annotations.UiThread;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import ro.androidiasi.codecamp.data.website.Codecamp;
import ro.androidiasi.codecamp.data.model.DataCodecamper;
import ro.androidiasi.codecamp.data.model.DataRoom;
import ro.androidiasi.codecamp.data.model.DataSession;
import ro.androidiasi.codecamp.data.model.DataTimeFrame;
import ro.androidiasi.codecamp.data.source.IAgendaDataSource;
import ro.androidiasi.codecamp.data.source.ILoadCallback;

/**
 * Created by andrei on 06/04/16.
 */
@EBean
public class AgendaRemoteDataSource implements IAgendaDataSource<Long> {

    private static final String TAG = AgendaRemoteDataSource.class.getSimpleName();
    @RootContext Context mContext;

    private WebView mWebView;

    private List<DataCodecamper> mDataCodecampers = new ArrayList<>();
    private List<DataRoom> mDataRooms = new ArrayList<>();
    private List<DataSession> mDataSessions = new ArrayList<>();
    private List<DataTimeFrame> mTimeFrames = new ArrayList<>();

    @AfterInject public void afterMembersInject(){
        mWebView = new WebView(mContext);
        mWebView.loadUrl("http://iasi.codecamp.ro/");
        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.addJavascriptInterface(this, "android");
        mWebView.setWebViewClient(new WebViewClient() {
            @Override public void onPageFinished(WebView view, String url) {
                if(mWebView != null){
                    mWebView.loadUrl("javascript:android.onData(ko.toJSON(new ConferenceViewModel()))");
                }
            }
        });
    }

    @JavascriptInterface public void onData(String data){
        this.onDataCallback(data);
        this.onUiThreadDestroyWebView();
    }

    public void onDataCallback(String data){
        Log.d("AgendaRemoteDataSource", data);
        Codecamp codecamp = null;
        try {
            codecamp = new ObjectMapper().readValue(data, Codecamp.class);
        } catch (IOException pE) {
            Log.e(TAG, pE.getMessage());
        }
        if(codecamp != null){
            this.mDataCodecampers = DataCodecamper.fromSpeakersList(codecamp.getConference().getSpeakers());
            this.mDataRooms = DataRoom.fromTracksList(codecamp.getConference().getAgenda().getTracks());
            this.mTimeFrames = DataTimeFrame.fromTimeSlotsList(codecamp.getConference().getAgenda().getTimeSlots());
            this.mDataSessions = DataSession.fromBookingsList(codecamp.getConference().getAgenda().getBookings());
        }
        this.onUiThreadDestroyWebView();
    }

    @UiThread public void onUiThreadDestroyWebView() {
        if(mWebView != null) {
            mWebView.clearHistory();
            mWebView.clearCache(true);
            mWebView.loadUrl("about:blank");
            mWebView.freeMemory();
            mWebView.pauseTimers();
            mWebView = null;
        }
        System.gc();
    }

    @Override public void getRoomsList(ILoadCallback<List<DataRoom>> pLoadCallback) {
        pLoadCallback.onSuccess(mDataRooms);
    }

    @Override public void getSessionsList(ILoadCallback<List<DataSession>> pLoadCallback) {
        pLoadCallback.onSuccess(mDataSessions);
    }

    @Override public void getFavoriteSessionsList(ILoadCallback<List<DataSession>> pLoadCallback) {
        pLoadCallback.onSuccess(mDataSessions);
    }

    @Override public void getTimeFramesList(ILoadCallback<List<DataTimeFrame>> pLoadCallback) {
        pLoadCallback.onSuccess(mTimeFrames);
    }

    @Override public void getCodecampersList(ILoadCallback<List<DataCodecamper>> pLoadCallback) {
        pLoadCallback.onSuccess(mDataCodecampers);
    }

    @Override public void getRoom(Long pLong, ILoadCallback<DataRoom> pLoadCallback) {

    }

    @Override public void getSession(Long pLong, ILoadCallback<DataSession> pLoadCallback) {

    }

    @Override public void getTimeFrame(Long pLong, ILoadCallback<DataTimeFrame> pLoadCallback) {

    }

    @Override public void getCodecamper(Long pLong, ILoadCallback<DataCodecamper> pLoadCallback) {

    }

    @Override public void isSessionFavorite(Long pLong, ILoadCallback<DataSession> pLoadCallback) {

    }

    @Override public void setSessionFavorite(Long pLong, boolean pFavorite, ILoadCallback<DataSession> pLoadCallback) {

    }
}
