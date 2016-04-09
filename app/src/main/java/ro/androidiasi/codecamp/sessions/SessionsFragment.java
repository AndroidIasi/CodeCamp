package ro.androidiasi.codecamp.sessions;

import android.support.v7.widget.RecyclerView;

import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import ro.androidiasi.codecamp.BaseFragment;
import ro.androidiasi.codecamp.R;

/**
 * Created by andrei on 08/04/16.
 */
@EFragment(R.layout.fragment_sessions_list)
public class SessionsFragment extends BaseFragment implements SessionsContract.View {

    @ViewById(R.id.recycler) RecyclerView mRecyclerView;

    public static SessionsFragment newInstance(){
        return SessionsFragment_.builder().build();
    }

}
