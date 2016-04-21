package ro.androidiasi.codecamp.data.source.remote;

import android.util.Log;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.UiThread;

import java.io.IOException;
import java.util.List;

import ro.androidiasi.codecamp.data.crawler.Codecamp;
import ro.androidiasi.codecamp.data.model.DataCodecamp;
import ro.androidiasi.codecamp.data.model.DataCodecamper;
import ro.androidiasi.codecamp.data.model.DataRoom;
import ro.androidiasi.codecamp.data.model.DataSession;
import ro.androidiasi.codecamp.data.model.DataTimeFrame;
import ro.androidiasi.codecamp.data.source.IAgendaDataSource;
import ro.androidiasi.codecamp.data.source.ILoadCallback;
import ro.androidiasi.codecamp.data.source.remote.exception.DataUnavailable;

/**
 * Created by andrei on 21/04/16.
 */
@EBean
public abstract class BaseRemoteDataSource implements IRemoteClient, IAgendaDataSource<Long> {

    private static final String TAG = "BaseRemoteDataSource";
    private ObjectMapper mObjectMapper;
    private ILoadCallback<List<DataRoom>> mDataRoomListCallback;
    private ILoadCallback<List<DataSession>> mDataSessionListCallback;
    private ILoadCallback<List<DataTimeFrame>> mDataTimeFrameListCallback;
    private ILoadCallback<List<DataCodecamper>> mDataCodecamperListCallback;

    @AfterInject public void afterMembersInject(){
        this.mObjectMapper = new ObjectMapper();
        this.afterInject();
    }

    public void afterInject(){};

    @Background
    @Override public void getRoomsList(final ILoadCallback<List<DataRoom>> pLoadCallback) {
        this.mDataRoomListCallback = pLoadCallback;
        this.requestData(pLoadCallback);
    }

    @Background
    @Override public void getSessionsList(final ILoadCallback<List<DataSession>> pLoadCallback) {
        this.mDataSessionListCallback = pLoadCallback;
        this.requestData(pLoadCallback);
    }

    @Background
    @Override public void getFavoriteSessionsList(final ILoadCallback<List<DataSession>> pLoadCallback) {
        //not storing favorites on the web
    }

    @Background
    @Override public void getTimeFramesList(ILoadCallback<List<DataTimeFrame>> pLoadCallback) {
        this.mDataTimeFrameListCallback = pLoadCallback;
        this.requestData(pLoadCallback);
    }

    @Background
    @Override public void getCodecampersList(ILoadCallback<List<DataCodecamper>> pLoadCallback) {
        this.mDataCodecamperListCallback = pLoadCallback;
        this.requestData(pLoadCallback);
    }

    @Background
    @Override public void getRoom(Long pLong, ILoadCallback<DataRoom> pLoadCallback) {

    }

    @Background
    @Override public void getSession(Long pLong, ILoadCallback<DataSession> pLoadCallback) {

    }

    @Background
    @Override public void getTimeFrame(Long pLong, ILoadCallback<DataTimeFrame> pLoadCallback) {

    }

    @Background
    @Override public void getCodecamper(Long pLong, ILoadCallback<DataCodecamper> pLoadCallback) {

    }

    @Background
    @Override public void isSessionFavorite(Long pLong, ILoadCallback<Boolean> pLoadCallback) {

    }

    @Background
    @Override public void setSessionFavorite(Long pLong, boolean pFavorite, ILoadCallback<Boolean> pLoadCallback) {

    }

    @UiThread
    @Override public <Model> void onUiThreadCallOnSuccessCallback(ILoadCallback<Model> pLoadCallback, Model pModel) {
        pLoadCallback.onSuccess(pModel);
    }

    @UiThread
    @Override public <E extends Exception> void onUiThreadCallOnFailureCallback(ILoadCallback pLoadCallback, E pException) {
        pLoadCallback.onFailure(pException);
    }

    private DataCodecamp getDataCodecampFromJson(String pDataJson) throws IOException {
        Codecamp codecamp = this.mObjectMapper.readValue(pDataJson, Codecamp.class);
        return DataCodecamp.fromCrawlerCodecamp(codecamp);
    }

    private<Model> void requestData(ILoadCallback<Model> pLoadCallback) {//this does not look good :)
        try {
            this.startCodecampJsonRequest();
        } catch (DataUnavailable pDataUnavailable) {
            this.onUiThreadCallOnFailureCallback(pLoadCallback, pDataUnavailable);
        }
    }

    /**
     * Webview triggers this method with the returned json;
     * Due to the onData() webview call...I'm losing track of the
     * callback I need to do.
     * I came up with this solution, keep a reference to the callback,
     * each time a request is done and remove it afer the json is returned.
     *
     * To implement more requests we need to specifically identify the callbacks, so
     * we need to add more ILoadCallback references.
     *
     * Or we could use an API... :))
     * @param pObject The Json returned by the webview
     */
    @Override public void onSuccess(String pObject) {
        DataCodecamp dataCodecamp = null;
        try {
            dataCodecamp = getDataCodecampFromJson(pObject);
        } catch (IOException pE) {
            this.onUiThreadCallOnFailureCallback(this, pE);
        }
        if(dataCodecamp != null){
            if(mDataSessionListCallback != null){
                this.onUiThreadCallOnSuccessCallback(mDataSessionListCallback, dataCodecamp.getDataSessions());
                this.mDataSessionListCallback = null;
            }
            if(mDataRoomListCallback != null){
                this.onUiThreadCallOnSuccessCallback(mDataRoomListCallback, dataCodecamp.getDataRooms());
                this.mDataRoomListCallback = null;
            }
            if(mDataTimeFrameListCallback != null){
                this.onUiThreadCallOnSuccessCallback(mDataTimeFrameListCallback, dataCodecamp.getTimeFrames());
                this.mDataTimeFrameListCallback = null;
            }
            if(mDataCodecamperListCallback != null) {
                this.onUiThreadCallOnSuccessCallback(mDataCodecamperListCallback, dataCodecamp.getDataCodecampers());
                this.mDataCodecamperListCallback = null;
            }
        }
    }

    @Override public void onFailure(Exception pException) {
        Log.e(TAG, "onFailure: ", pException);
    }
}
