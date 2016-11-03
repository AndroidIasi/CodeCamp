package ro.androidiasi.codecamp.codecampers;

import android.content.Context;
import android.view.ViewGroup;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;

import ro.androidiasi.codecamp.codecampers.item.CodecamperItemPresenter;
import ro.androidiasi.codecamp.codecampers.item.CodecamperItemView;
import ro.androidiasi.codecamp.codecampers.item.CodecamperItemView_;
import ro.androidiasi.codecamp.internal.model.Codecamper;
import ro.androidiasi.codecamp.internal.recycler.BaseListViewAdapter;

/**
 * Created by andrei on 19/04/16.
 */
@EBean
public class CodecampersAdapter
        extends BaseListViewAdapter<Codecamper, CodecamperItemView, CodecamperItemPresenter> {

    @Bean CodecamperItemPresenter mCodecamperItemPresenter;
    @RootContext Context mContext;

    @Override protected CodecamperItemView getItemView(ViewGroup parent) {
        return CodecamperItemView_.build(mContext);
    }

    @Override protected CodecamperItemPresenter getPresenter() {
        return mCodecamperItemPresenter;
    }

}
