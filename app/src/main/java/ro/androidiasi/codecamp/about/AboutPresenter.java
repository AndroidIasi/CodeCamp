package ro.androidiasi.codecamp.about;

import android.content.Context;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;

import java.util.ArrayList;
import java.util.List;

import ro.androidiasi.codecamp.BuildConfig;
import ro.androidiasi.codecamp.Navigator;
import ro.androidiasi.codecamp.R;
import ro.androidiasi.codecamp.data.source.DataConference;
import ro.androidiasi.codecamp.data.source.IAgendaDataSource;
import ro.androidiasi.codecamp.data.source.ILoadCallback;
import ro.androidiasi.codecamp.internal.model.Conference;

/**
 * Created by andrei on 20/04/16.
 */
@EBean
public class AboutPresenter implements AboutContract.Presenter {


    private IAgendaDataSource<Long> mRepository;
    private List<DataConference> mDataConferences;
    @Bean Navigator mNavigator;
    @RootContext Context mContext;

    private AboutContract.View mView;

    @Override public void setView(final AboutContract.View pView) {
        this.mView = pView;
        if (mDataConferences == null) {
            mRepository.getConferencesList(new ILoadCallback<List<DataConference>>() {
                @Override public void onSuccess(List<DataConference> pObject) {
                    mDataConferences = DataConference.listByDateAscending(pObject);
                    mView.onConferencesRetrieved(Conference.fromDataConferenceList(mDataConferences));
                }

                @Override public void onFailure(Exception pException) {
                    // TODO: Error handling inside About
                }
            });
        } else {
            mView.onConferencesRetrieved(Conference.fromDataConferenceList(mDataConferences));
        }
    }

    @Override public void afterViews() {
        String version = mContext.getString(R.string.version,
                BuildConfig.VERSION_NAME,
                BuildConfig.VERSION_CODE);
        this.mView.getVersionTextView().setText(version);
    }

    @Override public void onThisAppIsOpenSourceClicked() {
        mNavigator.goToWebPage("https://github.com/AndroidIasi/Codecamp");
    }

    @Override public void setRepository(IAgendaDataSource<Long> pRepository) {
        mRepository = pRepository;
    }

    @Override public void onConferenceSelected(Conference conference) {
        String conferenceId = conference.getStringId();
        DataConference selectedConference = DataConference.getFromString(mDataConferences, conferenceId);
        DataConference currentConference = mRepository.getConference();
        if (!selectedConference.equals(currentConference)) {
            mRepository.setConference(selectedConference);
            mRepository.invalidate();
            mView.notifyChangingConference();
        }
    }
}
