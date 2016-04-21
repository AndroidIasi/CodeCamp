package ro.androidiasi.codecamp.data.source;

import android.util.Log;

import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.UiThread;

import java.util.List;

import ro.androidiasi.codecamp.data.model.DataCodecamper;
import ro.androidiasi.codecamp.data.model.DataRoom;
import ro.androidiasi.codecamp.data.model.DataSession;
import ro.androidiasi.codecamp.data.model.DataTimeFrame;
import ro.androidiasi.codecamp.data.source.local.AgendaLocalSnappyDataSource;
import ro.androidiasi.codecamp.data.source.local.exception.DataNotFoundException;
import ro.androidiasi.codecamp.data.source.remote.FileRemoteDataSource;
import ro.androidiasi.codecamp.data.source.remote.WebViewRemoteDataSource;

/**
 * Created by andrei on 06/04/16.
 */
@EBean(scope = EBean.Scope.Singleton)
public class AgendaRepository implements IAgendaDataSource<Long> {

    private static final String TAG = "AgendaRepository";
    @Bean AgendaLocalSnappyDataSource mLocalSnappyDataSource;
    @Bean FileRemoteDataSource mFileRemoteDataSource;
    @Bean WebViewRemoteDataSource mWebViewRemoteDataSource;

    private List<DataRoom> mMemCacheDataRooms;
    private List<DataTimeFrame> mMemCacheTimeFrame;
    private List<DataCodecamper> mMemCacheDataCodecampers;
    private List<DataSession> mMemCacheDataSession;

    @Background
    @Override public void getRoomsList(boolean pForced, final ILoadCallback<List<DataRoom>> pLoadCallback) {
        if(pForced){
            this.invalidateDataRoomsList();
        }
        this.getRoomsList(pLoadCallback);
    }

    @Background
    @Override public void getSessionsList(boolean pForced, final ILoadCallback<List<DataSession>> pLoadCallback) {
        if(pForced){
            this.invalidateDataSessions();
        }
        this.getSessionsList(pLoadCallback);
    }


    @Background
    @Override public void getFavoriteSessionsList(boolean pFroced, final ILoadCallback<List<DataSession>> pLoadCallback) {
        this.getFavoriteSessionsList(pLoadCallback);
    }

    @Background
    @Override public void getTimeFramesList(boolean pForced, final ILoadCallback<List<DataTimeFrame>> pLoadCallback) {
        if(pForced){
            this.inavlidateTimeFrameList();
        }
        this.getTimeFramesList(pLoadCallback);
    }

    @Background
    @Override public void getCodecampersList(boolean pForced, final ILoadCallback<List<DataCodecamper>> pLoadCallback) {
        if(pForced){
            this.invalidateCodecampersList();
        }
        this.getCodecampersList(pLoadCallback);
    }

    @Override public void getRoomsList(final ILoadCallback<List<DataRoom>> pLoadCallback) {
        if(mMemCacheDataRooms != null){
            this.onUiThreadCallOnSuccessCallback(pLoadCallback, mMemCacheDataRooms);
            return;
        }
        this.mLocalSnappyDataSource.getRoomsList(new ILoadCallback<List<DataRoom>>() {
            @Override public void onSuccess(List<DataRoom> pObject) {
                if(pObject == null){
                    this.onFailure(new DataNotFoundException());
                    return;
                }
                mMemCacheDataRooms = pObject;
                onUiThreadCallOnSuccessCallback(pLoadCallback, pObject);
            }

            @Override public void onFailure(Exception pException) {
                mFileRemoteDataSource.getRoomsList(new ILoadCallback<List<DataRoom>>() {
                    @Override public void onSuccess(List<DataRoom> pObject) {
                        if(pObject == null){
                            this.onFailure(new DataNotFoundException());
                            return;
                        }
                        mMemCacheDataRooms = pObject;
                        mLocalSnappyDataSource.storeDataRooms(pObject);
                        onUiThreadCallOnSuccessCallback(pLoadCallback, pObject);
                        //call this to get the most fresh data :)
                        //don't rely on the local JSON :D
                        this.onFailure(new DataNotFoundException());
                    }

                    @Override public void onFailure(Exception pException) {
                        mWebViewRemoteDataSource.getRoomsList(new ILoadCallback<List<DataRoom>>() {
                            @Override public void onSuccess(List<DataRoom> pObject) {
                                if(pObject == null){
                                    this.onFailure(new DataNotFoundException());
                                    return;
                                }
                                mMemCacheDataRooms = pObject;
                                mLocalSnappyDataSource.storeDataRooms(pObject);
                                onUiThreadCallOnSuccessCallback(pLoadCallback, pObject);
                            }

                            @Override public void onFailure(Exception pException) {
                                Log.e(TAG, "onFailure: Can't fail more than that :))", pException);
                                onUiThreadCallOnFailureCallback(pLoadCallback, pException);
                            }
                        });
                        onUiThreadCallOnFailureCallback(pLoadCallback, pException);
                    }
                });
            }
        });    }

    @Override public void getSessionsList(final ILoadCallback<List<DataSession>> pLoadCallback) {
        if(mMemCacheDataSession != null){
            this.onUiThreadCallOnSuccessCallback(pLoadCallback, mMemCacheDataSession);
            return;
        }
        this.mLocalSnappyDataSource.getSessionsList(new ILoadCallback<List<DataSession>>() {
            @Override public void onSuccess(List<DataSession> pObject) {
                if(pObject == null){
                    this.onFailure(new DataNotFoundException());
                    return;
                }
                mMemCacheDataSession = pObject;
                onUiThreadCallOnSuccessCallback(pLoadCallback, pObject);
            }

            @Override public void onFailure(Exception pException) {
                mFileRemoteDataSource.getSessionsList(new ILoadCallback<List<DataSession>>() {
                    @Override public void onSuccess(List<DataSession> pObject) {
                        if(pObject == null){
                            this.onFailure(new DataNotFoundException());
                            return;
                        }
                        mMemCacheDataSession = pObject;
                        mLocalSnappyDataSource.storeDataSessions(pObject);
                        onUiThreadCallOnSuccessCallback(pLoadCallback, pObject);
                        //call this to get the most fresh data :)
                        //don't rely on the local JSON :D
                        this.onFailure(new DataNotFoundException());
                    }

                    @Override public void onFailure(Exception pException) {
                        mWebViewRemoteDataSource.getSessionsList(new ILoadCallback<List<DataSession>>() {
                            @Override public void onSuccess(List<DataSession> pObject) {
                                if(pObject == null){
                                    this.onFailure(new DataNotFoundException());
                                    return;
                                }
                                mMemCacheDataSession = pObject;
                                mLocalSnappyDataSource.storeDataSessions(pObject);
                                onUiThreadCallOnSuccessCallback(pLoadCallback, pObject);
                            }

                            @Override public void onFailure(Exception pException) {
                                Log.e(TAG, "onFailure: Can't fail more than that :))", pException);
                                onUiThreadCallOnFailureCallback(pLoadCallback, pException);
                            }
                        });
                        onUiThreadCallOnFailureCallback(pLoadCallback, pException);
                    }
                });
            }
        });
    }

    @Override public void getFavoriteSessionsList(final ILoadCallback<List<DataSession>> pLoadCallback) {
        this.mLocalSnappyDataSource.getFavoriteSessionsList(new ILoadCallback<List<DataSession>>() {
            @Override public void onSuccess(List<DataSession> pObject) {
                onUiThreadCallOnSuccessCallback(pLoadCallback, pObject);
            }

            @Override public void onFailure(Exception pException) {
                onUiThreadCallOnFailureCallback(pLoadCallback, pException);
            }
        });
    }

    @Override public void getTimeFramesList(final ILoadCallback<List<DataTimeFrame>> pLoadCallback) {
        if(mMemCacheTimeFrame != null){
            this.onUiThreadCallOnSuccessCallback(pLoadCallback, mMemCacheTimeFrame);
            return;
        }
        this.mLocalSnappyDataSource.getTimeFramesList(new ILoadCallback<List<DataTimeFrame>>() {
            @Override public void onSuccess(List<DataTimeFrame> pObject) {
                if(pObject == null){
                    this.onFailure(new DataNotFoundException());
                    return;
                }
                mMemCacheTimeFrame = pObject;
                onUiThreadCallOnSuccessCallback(pLoadCallback, pObject);
            }

            @Override public void onFailure(Exception pException) {
                mFileRemoteDataSource.getTimeFramesList(new ILoadCallback<List<DataTimeFrame>>() {
                    @Override public void onSuccess(List<DataTimeFrame> pObject) {
                        if(pObject == null){
                            this.onFailure(new DataNotFoundException());
                            return;
                        }
                        mMemCacheTimeFrame = pObject;
                        mLocalSnappyDataSource.storeDataTimeFrames(pObject);
                        onUiThreadCallOnSuccessCallback(pLoadCallback, pObject);
                        //call this to get the most fresh data :)
                        //don't rely on the local JSON :D
                        this.onFailure(new DataNotFoundException());
                    }

                    @Override public void onFailure(Exception pException) {
                        mWebViewRemoteDataSource.getTimeFramesList(new ILoadCallback<List<DataTimeFrame>>() {
                            @Override public void onSuccess(List<DataTimeFrame> pObject) {
                                if(pObject == null){
                                    this.onFailure(new DataNotFoundException());
                                    return;
                                }
                                mMemCacheTimeFrame = pObject;
                                mLocalSnappyDataSource.storeDataTimeFrames(pObject);
                                onUiThreadCallOnSuccessCallback(pLoadCallback, pObject);
                            }

                            @Override public void onFailure(Exception pException) {
                                Log.e(TAG, "onFailure: Can't fail more than that :))", pException);
                                onUiThreadCallOnFailureCallback(pLoadCallback, pException);
                            }
                        });
                        onUiThreadCallOnFailureCallback(pLoadCallback, pException);
                    }
                });
            }
        });
    }

    @Override public void getCodecampersList(final ILoadCallback<List<DataCodecamper>> pLoadCallback) {
        if(mMemCacheDataCodecampers != null){
            this.onUiThreadCallOnSuccessCallback(pLoadCallback, mMemCacheDataCodecampers);
            return;
        }
        this.mLocalSnappyDataSource.getCodecampersList(new ILoadCallback<List<DataCodecamper>>() {
            @Override public void onSuccess(List<DataCodecamper> pObject) {
                if(pObject == null){
                    this.onFailure(new DataNotFoundException());
                    return;
                }
                mMemCacheDataCodecampers = pObject;
                onUiThreadCallOnSuccessCallback(pLoadCallback, pObject);
            }

            @Override public void onFailure(Exception pException) {
                mFileRemoteDataSource.getCodecampersList(new ILoadCallback<List<DataCodecamper>>() {
                    @Override public void onSuccess(List<DataCodecamper> pObject) {
                        if(pObject == null){
                            this.onFailure(new DataNotFoundException());
                            return;
                        }
                        mMemCacheDataCodecampers = pObject;
                        mLocalSnappyDataSource.storeDataCodecampers(pObject);
                        onUiThreadCallOnSuccessCallback(pLoadCallback, pObject);
                        //call this to get the most fresh data :)
                        //don't rely on the local JSON :D
                        this.onFailure(new DataNotFoundException());
                    }

                    @Override public void onFailure(Exception pException) {
                        mWebViewRemoteDataSource.getCodecampersList(new ILoadCallback<List<DataCodecamper>>() {
                            @Override public void onSuccess(List<DataCodecamper> pObject) {
                                if(pObject == null){
                                    this.onFailure(new DataNotFoundException());
                                    return;
                                }
                                mMemCacheDataCodecampers = pObject;
                                mLocalSnappyDataSource.storeDataCodecampers(pObject);
                                onUiThreadCallOnSuccessCallback(pLoadCallback, pObject);
                            }

                            @Override public void onFailure(Exception pException) {
                                Log.e(TAG, "onFailure: Can't fail more than that :))", pException);
                                onUiThreadCallOnFailureCallback(pLoadCallback, pException);
                            }
                        });
                        onUiThreadCallOnFailureCallback(pLoadCallback, pException);
                    }
                });
            }
        });
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
    @Override public void isSessionFavorite(Long pLong, final ILoadCallback<Boolean> pLoadCallback) {
        mLocalSnappyDataSource.isSessionFavorite(pLong, new ILoadCallback<Boolean>() {
            @Override public void onSuccess(Boolean pObject) {
                onUiThreadCallOnSuccessCallback(pLoadCallback, pObject);
            }

            @Override public void onFailure(Exception pException) {
                onUiThreadCallOnFailureCallback(pLoadCallback, pException);
            }
        });
    }

    @Background
    @Override public void setSessionFavorite(Long pLong, boolean pFavorite, final ILoadCallback<Boolean> pLoadCallback) {
        this.mLocalSnappyDataSource.setSessionFavorite(pLong, pFavorite, new ILoadCallback<Boolean>() {
            @Override public void onSuccess(Boolean pObject) {
                onUiThreadCallOnSuccessCallback(pLoadCallback, pObject);
            }

            @Override public void onFailure(Exception pException) {
                onUiThreadCallOnFailureCallback(pLoadCallback, pException);
            }
        });
    }

    @UiThread public <Model> void onUiThreadCallOnSuccessCallback(ILoadCallback<Model> pLoadCallback, Model pModel) {
        pLoadCallback.onSuccess(pModel);
    }

    @UiThread public <E extends Exception> void onUiThreadCallOnFailureCallback(ILoadCallback pLoadCallback, E pException) {
        pLoadCallback.onFailure(pException);
    }

    private void invalidateDataRoomsList() {
        this.mMemCacheDataRooms = null;
        this.mLocalSnappyDataSource.invalidateDataRooms();
    }

    private void inavlidateTimeFrameList(){
        this.mMemCacheTimeFrame = null;
        this.mLocalSnappyDataSource.invalidateDataTimeFrames();
    }

    private void invalidateCodecampersList(){
        this.mMemCacheDataCodecampers = null;
        this.mLocalSnappyDataSource.invalidateDataCodecampers();
    }

    private void invalidateDataSessions(){
        this.mMemCacheDataSession = null;
        this.mLocalSnappyDataSource.invalidateDataSessions();
    }

    public void invalidate(){
        this.mMemCacheDataRooms = null;
        this.mMemCacheTimeFrame = null;
        this.mMemCacheDataCodecampers = null;
        this.mMemCacheDataSession = null;
        this.mLocalSnappyDataSource.invalidate();
    }
}
