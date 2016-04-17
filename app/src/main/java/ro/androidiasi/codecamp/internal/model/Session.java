package ro.androidiasi.codecamp.internal.model;

import java.util.ArrayList;
import java.util.List;

import ro.androidiasi.codecamp.data.model.DataSession;

/**
 * Created by andrei on 06/04/16.
 */
public final class Session extends AbstractModel {

    private final Codecamper mCodecamper;
    private final Room mRoom;
    private final String mName;
    private final String mDescription;
    private final TimeFrame mTimeFrame;

    private final boolean mFavorite;

    public Session(Codecamper pCodecamper, Room pRoom, String pName, String pDescription, TimeFrame pTimeFrame, boolean pFavorite) {
        mCodecamper = pCodecamper;
        mRoom = pRoom;
        mName = pName;
        mDescription = pDescription;
        mTimeFrame = pTimeFrame;
        mFavorite = pFavorite;
    }

    public Codecamper getCodecamper() {
        return mCodecamper;
    }

    public Room getRoom() {
        return mRoom;
    }

    public String getName() {
        return mName;
    }

    public String getDescription() {
        return mDescription;
    }

    public TimeFrame getTimeFrame() {
        return mTimeFrame;
    }


    public boolean isFavorite() {
        return mFavorite;
    }

    public static Session fromDataSession(DataSession pDataSession){
        return new Session(
              Codecamper.fromDataCodecamper(pDataSession.getDataCodecamper()),
                Room.fromDataRoom(pDataSession.getDataRoom()),
                pDataSession.getName(),
                pDataSession.getDescription(),
                TimeFrame.fromDataTimeFrame(pDataSession.getDataTimeFrame()),
                pDataSession.isFavorite()
        );
    }

    public static List<Session> fromDataSessionList(List<DataSession> pDataSessions){
        List<Session> sessions = new ArrayList<>();
        for (int i = 0; i < pDataSessions.size(); i++) {
            Session session = Session.fromDataSession(pDataSessions.get(i));
            sessions.add(session);
        }
        return sessions;
    }

}
