package ro.androidiasi.codecamp.internal.recycler;

import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

import ro.androidiasi.codecamp.internal.model.IModel;

/**
 * Created by andrei on 10/04/16.
 */
public abstract class BaseListViewAdapter<
        ModelType extends IModel,
        ViewType extends android.view.View,
        PresenterType extends IListViewItemPresenter<ModelType, ViewType>>
        extends BaseAdapter {

    private List<ModelType> mItems = new ArrayList<>();


    @Override public int getCount() {
        return mItems.size();
    }

    @Override public ModelType getItem(int position) {
        return mItems.get(position);
    }

    @Override public long getItemId(int position) {
        return mItems.get(position).getId();
    }

    @SuppressWarnings("unchecked")
    @Override public android.view.View getView(int position, android.view.View convertView,
                                               ViewGroup parent) {
        ViewType view = (ViewType) convertView;
        ModelType model =  this.getItem(position);
        if (view == null) {
            view = getItemView(parent);
        }
        this.getPresenter().bind(model, view);
        return view;
    }

    public void update(List<ModelType> pItems) {
        this.update(mItems, pItems);
    }

    public <ModelType> void update(List<ModelType> pDestination, List<ModelType> pItems) {
        pDestination.clear();
        pDestination.addAll(pItems);
        this.notifyDataSetChanged();
    }

    protected abstract ViewType getItemView(ViewGroup parent);
    protected abstract PresenterType getPresenter();
}
