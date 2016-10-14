package ro.androidiasi.codecamp.sessions.header;

import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.EBean;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import ro.androidiasi.codecamp.internal.model.Session;

/**
 * Created by andrei on 18/04/16.
 */
@EBean
public class SessionHeaderPresenter implements SessionHeaderContract.Presenter{

    @AfterInject public void afterMembersInject(){}

    @Override public void bind(Session pModel, SessionHeaderView pView) {
        String result = String.format("%s - %s",
                formatTime(pModel.getTimeFrame().getStartTime()),
                formatTime(pModel.getTimeFrame().getEndTime()));
        pView.getTimeTextView().setText(result);
    }

    private String formatTime(String pStartTime){
        //TODO: Remove the :00 at the end
        return pStartTime;
    }
}
