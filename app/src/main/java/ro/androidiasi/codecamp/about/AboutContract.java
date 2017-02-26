package ro.androidiasi.codecamp.about;

import android.widget.TextView;

import java.util.List;

import ro.androidiasi.codecamp.data.source.IAgendaDataSource;
import ro.androidiasi.codecamp.internal.IPresenter;
import ro.androidiasi.codecamp.internal.IView;
import ro.androidiasi.codecamp.internal.model.Conference;

/**
 * Created by andrei on 20/04/16.
 */
public interface AboutContract {

    interface View extends IView {
        TextView getVersionTextView();
        void onConferencesRetrieved(List<Conference> data);
        void notifyChangingConference();
    }

    interface Presenter extends IPresenter {
        void setView(View pView);

        void afterViews();

        void onThisAppIsOpenSourceClicked();

        void setRepository(IAgendaDataSource<Long> pRepository);

        void onConferenceSelected(Conference conference);
    }
}
