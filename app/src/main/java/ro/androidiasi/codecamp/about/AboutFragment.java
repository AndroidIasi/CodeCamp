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

    private boolean mIgnoreSelection = true;
    private List<Conference> mConferenceList;

    public static AboutFragment newInstance() {
        return AboutFragment_.builder().build();
    }

    @Override public void afterInject() {
        super.afterInject();
    }

    @Override public void afterViews() {
        super.afterViews();
        this.mAboutPresenter.setRepository(getRepository());
        this.mAboutPresenter.setView(this);
        this.mAboutPresenter.afterViews();
    }

    @Click(R.id.github_button) public void onGitHubButtonClicked() {
        this.mAboutPresenter.onThisAppIsOpenSourceClicked();
    }

    @ItemSelect(R.id.spinner) public void onSpinnerItemClicked(boolean pSelected,
                                                               Conference pConference) {
        if (!mIgnoreSelection) {
            this.onBackgroundChangeConference(pConference);
        }
    }

    @Background public void onBackgroundChangeConference(Conference pConference) {
        if (this.isAdded()) {
            mAboutPresenter.onConferenceSelected(pConference);
        }
    }

    @UiThread public void onUiThreadShowChangingConferenceToast() {
        Toast.makeText(getActivity(), "Loading, please wait...", Toast.LENGTH_LONG).show();
    }

    @Override public TextView getVersionTextView() {
        return this.mVersionTextView;
    }

    @Override public void onConferencesRetrieved(List<Conference> data) {
        mConferenceList = data;
        this.mSpinner.setAdapter(mSelectEventAdapter);
        this.mSelectEventAdapter.update(mConferenceList);
        for (int i = 0; i < mConferenceList.size(); i++) {
            Conference conference = mConferenceList.get(i);
            if (conference.getStringId().equals(getRepository().getConference().getId())) {
                mIgnoreSelection = true;
                this.mSpinner.setSelection(i);
                mIgnoreSelection = false;
            }
        }
    }

    @Override public void notifyChangingConference() {
        this.mCodecampBus.post(new EventRefreshLists());
        this.onUiThreadShowChangingConferenceToast();
    }
}
