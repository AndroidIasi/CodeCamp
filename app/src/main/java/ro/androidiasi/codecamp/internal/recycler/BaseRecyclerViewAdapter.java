package ro.androidiasi.codecamp.internal.recycler;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import ro.androidiasi.codecamp.internal.model.IModel;

/**
 * Created by andrei on 10/04/16.
 */
public abstract class BaseRecyclerViewAdapter<
        Model extends IModel,
        View extends android.view.View,
        Presenter extends IRecyclerItemPresenter<Model, View>>
        extends RecyclerView.Adapter<ViewDecorator<View>> {

    private List<Model> mItems = new ArrayList<>();

    @Override public ViewDecorator<View> onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewDecorator<>(getItemView(parent, viewType));
    }

    @Override public void onBindViewHolder(ViewDecorator<View> holder, int position) {
        View view = holder.getView();
        Model model = this.mItems.get(position);
        this.getPresenter().bind(model, view);
    }

    @Override public int getItemCount() {
        return this.mItems.size();
    }

    @Override public long getItemId(int position) {
        return mItems.get(position).getId();
    }

    public void update(List<Model> pItems){
        this.mItems.clear();
        this.mItems.addAll(pItems);
        this.notifyDataSetChanged();
    }

    protected abstract View getItemView(ViewGroup parent, int viewType);
    protected abstract Presenter getPresenter();
}
