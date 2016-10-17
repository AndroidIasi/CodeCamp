package ro.androidiasi.codecamp.sponsors;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.tonicartos.widget.stickygridheaders.StickyGridHeadersSimpleAdapter;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;

import ro.androidiasi.codecamp.internal.model.Sponsor;
import ro.androidiasi.codecamp.internal.recycler.BaseListViewAdapter;
import ro.androidiasi.codecamp.sponsors.header.SponsorHeaderPresenter;
import ro.androidiasi.codecamp.sponsors.header.SponsorHeaderView;
import ro.androidiasi.codecamp.sponsors.header.SponsorHeaderView_;
import ro.androidiasi.codecamp.sponsors.item.SponsorItemPresenter;
import ro.androidiasi.codecamp.sponsors.item.SponsorItemView;
import ro.androidiasi.codecamp.sponsors.item.SponsorItemView_;

/**
 * Created by andrei.
 */
@EBean
public class SponsorsAdapter extends BaseListViewAdapter<Sponsor, SponsorItemView,
        SponsorItemPresenter> implements StickyGridHeadersSimpleAdapter{

    @Bean SponsorItemPresenter mSponsorItemPresenter;
    @Bean SponsorHeaderPresenter mSponsorHeaderPresenter;
    @RootContext Context mContext;

    @Override protected SponsorItemView getItemView(ViewGroup parent) {
        return SponsorItemView_.build(mContext);
    }

    @Override protected SponsorItemPresenter getPresenter() {
        return mSponsorItemPresenter;
    }


    @Override public View getHeaderView(int position, View convertView, ViewGroup parent) {
        SponsorHeaderView view = (SponsorHeaderView) convertView;
        if(view == null){
            view = SponsorHeaderView_.build(mContext);
        }
        this.mSponsorHeaderPresenter.bind(getItem(position), view);
        return view;
    }

    @Override public long getHeaderId(int position) {
        return getItem(position).getSponsorshipPackage().hashCode();
    }
}
