package ro.androidiasi.codecamp.codecampers;

import android.support.v4.widget.SwipeRefreshLayout;
import android.widget.ListView;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ItemClick;
import org.androidannotations.annotations.ViewById;

import ro.androidiasi.codecamp.BaseFragment;
import ro.androidiasi.codecamp.R;
import ro.androidiasi.codecamp.internal.model.Codecamper;

/**
 * Created by andrei on 19/04/16.
 */
@EFragment(R.layout.fragment_codecampers_list)
public class CodecampersFragment extends BaseFragment implements CodecampersContract.View {

    @Bean CodecampersPresenter mCodecampersPresenter;
    @ViewById(R.id.swipe_to_refresh) SwipeRefreshLayout mSwipeRefreshLayout;
    @ViewById(R.id.list_view) ListView mListView;

    public static CodecampersFragment newInstance(){
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

    @ItemClick(R.id.list_view) public void onCodecamperListItemClicked(Codecamper pCodecamper){
        this.getNavigator().goToCodecamperDetails(getActivity().getSupportFragmentManager(), pCodecamper);
    }
}
