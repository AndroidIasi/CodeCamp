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
        Model extends IModel,
        View extends android.view.View,
        Presenter extends IListViewItemPresenter<Model, View>>
        extends BaseAdapter {

    private List<Model> mItems = new ArrayList<>();


    @Override public int getCount() {
        return mItems.size();
    }

    @Override public Model getItem(int position) {
        return mItems.get(position);
    }

    @Override public long getItemId(int position) {
        return mItems.get(position).getId();
    }

    @SuppressWarnings("unchecked")
    @Override public android.view.View getView(int position, android.view.View convertView, ViewGroup parent) {
        View view = (View) convertView;
        Model model =  this.getItem(position);
        if(view == null){
            view = getItemView(parent);
        }
        this.getPresenter().bind(model, view);
        return view;
    }

    public void update(List<Model> pItems){
        this.update(mItems, pItems);
    }

    public <TModel> void update(List<TModel> pDestination, List<TModel> pItems){
        pDestination.clear();
        pDestination.addAll(pItems);
        this.notifyDataSetChanged();
    }

    protected abstract View getItemView(ViewGroup parent);
    protected abstract Presenter getPresenter();
}
