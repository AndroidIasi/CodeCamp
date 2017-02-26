package ro.androidiasi.codecamp.codecampers;

import android.support.v4.app.FragmentManager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.widget.ListView;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ItemClick;
import org.androidannotations.annotations.ViewById;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import ro.androidiasi.codecamp.BaseFragment;
import ro.androidiasi.codecamp.R;
import ro.androidiasi.codecamp.about.EventRefreshLists;
import ro.androidiasi.codecamp.internal.model.Codecamper;
import ro.androidiasi.codecamp.main.EventStopSwipeToRefresh;

/**
 * Created by andrei on 19/04/16.
 */
@EFragment(R.layout.fragment_codecampers_list)
public class CodecampersFragment extends BaseFragment implements CodecampersContract.View {

    @Bean CodecampersPresenter mCodecampersPresenter;
    @ViewById(R.id.swipe_to_refresh) SwipeRefreshLayout mSwipeRefreshLayout;
    @ViewById(R.id.list_view) ListView mListView;

    public static CodecampersFragment newInstance() {
        return CodecampersFragment_.builder().build();
    }

    @Override public void afterViews() {
        super.afterViews();
        this.mCodecampersPresenter.setView(this);
        this.mCodecampersPresenter.setRepository(getRepository());
        this.mCodecampersPresenter.afterViews();
    }

    @Override public ListView getListView() {
        return mListView;
    }

    @Override public SwipeRefreshLayout getSwipeRefreshLayout() {
        return mSwipeRefreshLayout;
    }

    @Override public void onResume() {
        super.onResume();
        this.mCodecampersPresenter.refreshData(false);
    }

    @ItemClick(R.id.list_view) public void onCodecamperListItemClicked(Codecamper pCodecamper) {
        FragmentManager supportFragmentManager = getActivity().getSupportFragmentManager();
        this.getNavigator().goToCodecamperDetails(supportFragmentManager, pCodecamper);
    }

    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void onEventMainThread(EventStopSwipeToRefresh pEvent) {
        this.mSwipeRefreshLayout.setRefreshing(false);
    }

    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void onEventMainThread(EventRefreshLists pEvent) {
        this.mCodecampersPresenter.onRefresh();
    }
}
