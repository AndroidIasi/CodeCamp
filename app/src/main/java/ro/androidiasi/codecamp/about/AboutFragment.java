package ro.androidiasi.codecamp.about;

import android.support.v7.widget.AppCompatSpinner;
import android.widget.TextView;
import android.widget.Toast;

import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ItemSelect;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.ViewById;

import java.util.List;

import ro.androidiasi.codecamp.BaseFragment;
import ro.androidiasi.codecamp.R;
import ro.androidiasi.codecamp.data.source.DataConference;
import ro.androidiasi.codecamp.internal.model.Conference;

/**
 * Created by andrei on 20/04/16.
 */
@EFragment(R.layout.fragment_about)
public class AboutFragment extends BaseFragment implements AboutContract.View {

    @Bean AboutPresenter mAboutPresenter;
    @Bean SelectEventAdapter mSelectEventAdapter;
    @ViewById(R.id.version) TextView mVersionTextView;
    @ViewById(R.id.spinner) AppCompatSpinner mSpinner;

    private boolean mIgnoreFirstSelection = true;
    private List<Conference> mConferenceList;

    public static AboutFragment newInstance() {
        return AboutFragment_.builder().build();
    }

    @Override public void afterInject() {
        super.afterInject();
        List<DataConference> dataConferenceList = DataConference.listByDateAscending();
        mConferenceList = Conference.fromDataConferenceList(dataConferenceList);
        this.mSelectEventAdapter.update(mConferenceList);
    }

    @Override public void afterViews() {
        super.afterViews();
        this.mAboutPresenter.setView(this);
        this.mAboutPresenter.afterViews();
        this.mSpinner.setAdapter(mSelectEventAdapter);
        for (int i = 0; i < mConferenceList.size(); i++) {
            Conference conference = mConferenceList.get(i);
            if (conference.getStringId().equals(getRepository().getConference().toString())) {
                this.mSpinner.setSelection(i);
            }
        }
    }

    @Click(R.id.github_button) public void onGitHubButtonClicked() {
        this.mAboutPresenter.onThisAppIsOpenSourceClicked();
    }

    @ItemSelect(R.id.spinner) public void onSpinnerItemClicked(boolean pSelected,
                                                               Conference pConference) {
        if (!mIgnoreFirstSelection) {
            this.onBackgroundChangeConference(pConference);
        }
        mIgnoreFirstSelection = false;
    }

    @Background public void onBackgroundChangeConference(Conference pConference) {
        if (this.isAdded()) {
            String conferenceId = pConference.getStringId();
            DataConference selectedConference = DataConference.getFromString(conferenceId);
            DataConference currentConference = this.getRepository().getConference();
            if (!selectedConference.equals(currentConference)) {
                this.getRepository().setConference(selectedConference);
                this.getRepository().invalidate();
                this.mCodecampBus.post(new EventRefreshLists());
                this.onUiThreadShowChangingConferenceToast();
            }
        }
    }

    @UiThread public void onUiThreadShowChangingConferenceToast() {
        Toast.makeText(getActivity(), "Loading, please wait...", Toast.LENGTH_LONG).show();
    }

    @Override public TextView getVersionTextView() {
        return this.mVersionTextView;
    }
}
