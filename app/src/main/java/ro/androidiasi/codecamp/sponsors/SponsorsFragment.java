package ro.androidiasi.codecamp.sponsors;

import android.support.v4.widget.SwipeRefreshLayout;
import android.widget.Toast;

import com.tonicartos.widget.stickygridheaders.StickyGridHeadersGridView;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ItemClick;
import org.androidannotations.annotations.ViewById;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

import ro.androidiasi.codecamp.BaseFragment;
import ro.androidiasi.codecamp.Navigator;
import ro.androidiasi.codecamp.R;
import ro.androidiasi.codecamp.about.EventRefreshLists;
import ro.androidiasi.codecamp.internal.model.Sponsor;

/**
 * Created by andrei.
 */
@EFragment(R.layout.fragment_sponsors_list)
public class SponsorsFragment extends BaseFragment implements SponsorsContract.View,
        SwipeRefreshLayout.OnRefreshListener{

    @Bean Navigator mNavigator;
    @Bean(SponsorsPresenter.class) SponsorsContract.Presenter mPresenter;
    @Bean SponsorsAdapter mSponsorsAdapter;

    @ViewById(R.id.swipe_to_refresh) SwipeRefreshLayout mSwipeRefreshLayout;
    @ViewById(R.id.grid) StickyGridHeadersGridView mGridView;

    public static SponsorsFragment newInstance() {
        return SponsorsFragment_.builder().build();
    }

    @Override public void afterViews() {
        super.afterViews();
        this.mGridView.setAdapter(mSponsorsAdapter);
        this.mSwipeRefreshLayout.setColorSchemeResources(
                R.color.holo_blue_bright,
                R.color.holo_green_light,
                R.color.holo_orange_light,
                R.color.holo_red_light);
        this.mSwipeRefreshLayout.setOnRefreshListener(this);
    }

    @Override public void onResume() {
        super.onResume();
        this.mPresenter.setRepository(getRepository());
        this.mPresenter.setView(this);
        this.mPresenter.start();
    }

    @Override public void onPause() {
        super.onPause();
        this.mPresenter.setView(null);
    }

    @Override public void updateSponsors(List<Sponsor> pResult) {
        mSwipeRefreshLayout.setRefreshing(false);
        this.mSponsorsAdapter.update(pResult);
    }

    @Override public void onFailure() {
        mSwipeRefreshLayout.setRefreshing(false);
        Toast.makeText(getActivity(), getString(R.string.failure_load_sponsors),
                Toast.LENGTH_SHORT).show();
    }

    @Override public void onRefresh() {
        mPresenter.refreshSponsors(true);
    }

    @ItemClick(R.id.grid) void onSponsorClicked(int pPosition){
        String url = mSponsorsAdapter.getItem(pPosition).getWebsiteUrl();
        this.mNavigator.goToWebPage(url);
    }

    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void onEventMainThread(EventRefreshLists pEvent){
        this.onRefresh();
    }
}
