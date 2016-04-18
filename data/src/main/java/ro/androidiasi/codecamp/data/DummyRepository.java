package ro.androidiasi.codecamp.data;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EBean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ro.androidiasi.codecamp.data.favorites.FavoriteSessions;
import ro.androidiasi.codecamp.data.model.DataCodecamper;
import ro.androidiasi.codecamp.data.model.DataRoom;
import ro.androidiasi.codecamp.data.model.DataSession;
import ro.androidiasi.codecamp.data.model.DataTimeFrame;
import ro.androidiasi.codecamp.data.model.IDataModel;
import ro.androidiasi.codecamp.data.source.IAgendaDataSource;
import ro.androidiasi.codecamp.data.source.ILoadCallback;

/**
 * Created by andrei on 10/04/16.
 * No data available at the moment :( Andrei's workin' on it...
 */
@EBean(scope = EBean.Scope.Singleton)
public class DummyRepository implements IAgendaDataSource<Long> {

    @Bean FavoriteSessions mFavoriteSessions;

    List<DataRoom> mRoomsList;
    List<DataCodecamper> mCodecampersList;
    List<DataSession> mSessionsList;
    List<DataTimeFrame> mTimeFramesList;

    public DummyRepository(){
        this.mRoomsList = new ArrayList<>();
        this.mCodecampersList = new ArrayList<>();
        this.mSessionsList = new ArrayList<>();
        this.mTimeFramesList = new ArrayList<>();

        this.mRoomsList.add(new DataRoom("Everywhere", 0, 0));
        this.mRoomsList.add(new DataRoom("Room 1", -2, 150));
        this.mRoomsList.add(new DataRoom("Room 2", -2, 150));
        this.mRoomsList.add(new DataRoom("Room 3", -2, 150));
        this.mRoomsList.add(new DataRoom("Room 4", -2, 150));
        this.mRoomsList.add(new DataRoom("Room 5", -2, 150));
        this.mRoomsList.add(new DataRoom("Room 6", -1, 150));
        this.mRoomsList.add(new DataRoom("Room 7", -1, 150));
        this.mRoomsList.add(new DataRoom("Room 8", 0, 150));
        this.mRoomsList.add(new DataRoom("Room 9", 1, 150));
        this.mRoomsList.add(new DataRoom("Room 10", 11, 150));
        this.mRoomsList.add(new DataRoom("Room 11", 11, 150));

        this.mCodecampersList.add(new DataCodecamper(
                "Bugs Bunny",
                "Rabbit",
                "ACME",
                "Chews carrots all day...",
                "https://upload.wikimedia.org/wikipedia/en/2/26/Classic_bugsbunny.png")
        );
        this.mCodecampersList.add(new DataCodecamper(
                "Yosemite Sam",
                "Cowboy",
                "ACME",
                "Shoots Bugs Bunny all day...",
                "http://yosemitesamquotes.com/wp-content/uploads/Yosemite-Sam-Quotes-300x281.png")
        );
        this.mCodecampersList.add(new DataCodecamper(
                "Duffy Duck",
                "Wel...a Duck",
                "ACME",
                "Bugs Bugs Bunny all day...",
                "https://upload.wikimedia.org/wikipedia/en/thumb/f/f4/Daffy_Duck.svg/718px-Daffy_Duck.svg.png")
        );

        this.mTimeFramesList.add(new DataTimeFrame("Registration", new Date(), new Date()));
        this.mTimeFramesList.add(new DataTimeFrame("MeetTheSponsors", new Date(), new Date()));
        this.mTimeFramesList.add(new DataTimeFrame("MeetTheSponsorsBreak", new Date(), new Date()));
        this.mTimeFramesList.add(new DataTimeFrame("MeetTheSponsorsLine", new Date(), new Date()));
        this.mTimeFramesList.add(new DataTimeFrame("Timeslot1", new Date(), new Date()));
        this.mTimeFramesList.add(new DataTimeFrame("Timeslot2", new Date(), new Date()));
        this.mTimeFramesList.add(new DataTimeFrame("Session2Break", new Date(), new Date()));
        this.mTimeFramesList.add(new DataTimeFrame("Timeslot3", new Date(), new Date()));
        this.mTimeFramesList.add(new DataTimeFrame("Lunch", new Date(), new Date()));
        this.mTimeFramesList.add(new DataTimeFrame("Lunch__", new Date(), new Date()));
        this.mTimeFramesList.add(new DataTimeFrame("Timeslot4", new Date(), new Date()));
        this.mTimeFramesList.add(new DataTimeFrame("Timeslot5", new Date(), new Date()));
        this.mTimeFramesList.add(new DataTimeFrame("Timeslot6", new Date(), new Date()));
        this.mTimeFramesList.add(new DataTimeFrame("Session6Break", new Date(), new Date()));
        this.mTimeFramesList.add(new DataTimeFrame("VipCocktail", new Date(), new Date()));
        this.mTimeFramesList.add(new DataTimeFrame("AfterParty", new Date(), new Date()));

        this.mSessionsList.add(new DataSession(
                mCodecampersList,
                mRoomsList.get(0),
                "Welcome!",
                "Bugs Bunny welcomes everyoneBugs Bunny welcomes everyoneBugs Bunny welcomes everyone" +
                        "Bugs Bunny welcomes everyoneBugs Bunny welcomes everyone",
                mTimeFramesList.get(0)
        ));

        this.mSessionsList.add(new DataSession(
                mCodecampersList,
                mRoomsList.get(1),
                "Welcome!",
                "The best pistol in the west!",
                mTimeFramesList.get(1)
        ));
        this.mSessionsList.add(new DataSession(
                mCodecampersList,
                mRoomsList.get(2),
                "Welcome!",
                "Life of a duck...",
                mTimeFramesList.get(2)
        ));
        this.mSessionsList.add(new DataSession(
                mCodecampersList,
                mRoomsList.get(2),
                "Welcome!",
                "Carrots! Love them or hate them!",
                mTimeFramesList.get(3)
        ));
        this.mSessionsList.add(new DataSession(
                mCodecampersList,
                mRoomsList.get(4),
                "Welcome!",
                "Why the damn rabbit won't die?",
                mTimeFramesList.get(4)
        ));
        this.mSessionsList.add(new DataSession(
                mCodecampersList,
                mRoomsList.get(5),
                "Welcome!",
                "Ducks don't give a \"phoque\"!",//din fr.
                mTimeFramesList.get(5)
        ));
        this.mSessionsList.add(new DataSession(
                mCodecampersList,
                mRoomsList.get(0),
                "Welcome!",
                "Bugs Bunny welcomes everyone",
                mTimeFramesList.get(0)
        ));

        this.mSessionsList.add(new DataSession(
                mCodecampersList,
                mRoomsList.get(1),
                "Welcome!",
                "The best pistol in the west!",
                mTimeFramesList.get(1)
        ));
        this.mSessionsList.add(new DataSession(
                mCodecampersList,
                mRoomsList.get(2),
                "Welcome!",
                "Life of a duck...",
                mTimeFramesList.get(2)
        ));
        this.mSessionsList.add(new DataSession(
                mCodecampersList,
                mRoomsList.get(2),
                "Welcome!",
                "Carrots! Love them or hate them!",
                mTimeFramesList.get(3)
        ));
        this.mSessionsList.add(new DataSession(
                mCodecampersList,
                mRoomsList.get(4),
                "Welcome!",
                "Why the damn rabbit won't die?",
                mTimeFramesList.get(4)
        ));
        this.mSessionsList.add(new DataSession(
                mCodecampersList,
                mRoomsList.get(5),
                "Welcome!",
                "Ducks don't give a \"phoque\"!",//din fr.
                mTimeFramesList.get(5)
        ));
    }

    @Override public void getRoomsList(ILoadCallback<List<DataRoom>> pLoadCallback) {
        pLoadCallback.onSuccess(mRoomsList);
    }

    @Override public void getSessionsList(ILoadCallback<List<DataSession>> pLoadCallback) {
        pLoadCallback.onSuccess(mSessionsList);
    }

    @Override public void getTimeFramesList(ILoadCallback<List<DataTimeFrame>> pLoadCallback) {
        pLoadCallback.onSuccess(mTimeFramesList);
    }

    @Override public void getCodecampersList(ILoadCallback<List<DataCodecamper>> pLoadCallback) {
        pLoadCallback.onSuccess(mCodecampersList);
    }

    @Override public void getRoom(Long pLong, ILoadCallback<DataRoom> pLoadCallback) {
        pLoadCallback.onSuccess(this.getForId(mRoomsList, pLong));
    }

    @Override public void getSession(Long pLong, ILoadCallback<DataSession> pLoadCallback) {
        pLoadCallback.onSuccess(this.getForId(mSessionsList, pLong));
    }

    @Override public void getTimeFrame(Long pLong, ILoadCallback<DataTimeFrame> pLoadCallback) {
        pLoadCallback.onSuccess(this.getForId(mTimeFramesList, pLong));
    }

    @Override public void getCodecamper(Long pLong, ILoadCallback<DataCodecamper> pLoadCallback) {
        pLoadCallback.onSuccess(this.getForId(mCodecampersList, pLong));
    }

    @Override public void isSessionFavorite(Long pLong, ILoadCallback<DataSession> pLoadCallback) {
        Boolean isFavorite = this.mFavoriteSessions.isFavorite(pLong);
        DataSession dataSession = this.getForId(mSessionsList, pLong);
        dataSession.setFavorite(isFavorite);
        pLoadCallback.onSuccess(dataSession);
    }

    @Override public void setSessionFavorite(Long pLong,final boolean pFavorite, ILoadCallback<DataSession> pLoadCallback) {
        DataSession dataSession = getForId(mSessionsList, pLong);
        dataSession.setFavorite(pFavorite);
        this.mFavoriteSessions.put(pLong, pFavorite);
        pLoadCallback.onSuccess(dataSession);
    }

    @SuppressWarnings("unchecked")
    public <Model extends IDataModel> Model getForId(List<Model> pModelList, Long pLong) {
        for(IDataModel dataModel : pModelList){
            if(dataModel.getId().equals(pLong)){
                return (Model)dataModel;
            }
        }
        return null;
    }

}
