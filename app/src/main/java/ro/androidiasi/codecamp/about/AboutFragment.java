package ro.androidiasi.codecamp.about;

import android.widget.TextView;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import ro.androidiasi.codecamp.BaseFragment;
import ro.androidiasi.codecamp.R;

/**
 * Created by andrei on 20/04/16.
 */
@EFragment(R.layout.fragment_about)
public class AboutFragment extends BaseFragment implements AboutContract.View {

    @Bean AboutPresenter mAboutPresenter;
    @ViewById(R.id.version) TextView mVersionTextView;

    public static AboutFragment newInstance(){
        return AboutFragment_.builder().build();
    }

    @Override public void afterViews() {
        super.afterViews();
        this.mAboutPresenter.setView(this);
        this.mAboutPresenter.afterViews();
    }

    @Click(R.id.github_button) public void onGitHubButtonClicked(){
        this.mAboutPresenter.onThisAppIsOpenSourceClicked();
    }

    @Override public TextView getVersionTextView() {
        return this.mVersionTextView;
    }
}
