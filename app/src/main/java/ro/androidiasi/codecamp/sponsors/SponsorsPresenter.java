package ro.androidiasi.codecamp.sponsors;

import org.androidannotations.annotations.EBean;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import ro.androidiasi.codecamp.data.model.DataSponsor;
import ro.androidiasi.codecamp.data.source.IAgendaDataSource;
import ro.androidiasi.codecamp.data.source.ILoadCallback;
import ro.androidiasi.codecamp.internal.model.Sponsor;

/**
 * Created by andrei.
 */
@EBean
public class SponsorsPresenter implements SponsorsContract.Presenter{


    private IAgendaDataSource<Long> mRepository;
    private SponsorsContract.View mView;

    @Override public void start() {
        if(mRepository == null){
            throw new NullPointerException("Repository is NULL");
        }
        if(mView == null){
            throw new NullPointerException("View is NULL");
        }
        this.refreshSponsors(false);
    }

    @Override public void setRepository(IAgendaDataSource<Long> pRepository) {
        mRepository = pRepository;
    }

    @Override public void setView(SponsorsContract.View pView) {
        mView = pView;
    }

    @Override public SponsorsContract.View getView() {
        return mView;
    }

    @Override public void refreshSponsors(boolean pForced) {
        this.mRepository.getSponsorsList(pForced, new ILoadCallback<List<DataSponsor>>() {
            @Override public void onSuccess(List<DataSponsor> pDataSponsorList) {
                final List<Sponsor> sponsorsList = Sponsor.fromDataSponsorsList(pDataSponsorList);
                final Map<String, Integer> displayPackageOrder = new HashMap<>();
                for (int i = 0; i < sponsorsList.size(); i++) {
                    displayPackageOrder.put(sponsorsList.get(i).getSponsorshipPackage(),
                            sponsorsList.get(i).getSponsorshipPackageDisplayOrder());
                }
                TreeMap<String, List<Sponsor>> groupByPackageTree = new TreeMap<>(new Comparator<String>() {
                    @Override public int compare(String lhs, String rhs) {
                        return displayPackageOrder.get(lhs) - displayPackageOrder.get(rhs);
                    }
                });
                for (int i = 0; i < sponsorsList.size(); i++) {
                    String key = sponsorsList.get(i).getSponsorshipPackage();
                    List<Sponsor> mapSponsors = groupByPackageTree.get(key);
                    if(mapSponsors == null){
                        groupByPackageTree.put(key, new ArrayList<Sponsor>());
                    }
                    groupByPackageTree.get(key).add(sponsorsList.get(i));
                }
                List<Sponsor> result = new ArrayList<>();
                for(String key : groupByPackageTree.keySet()){
                    Collections.sort(groupByPackageTree.get(key), new Comparator<Sponsor>() {
                        @Override public int compare(Sponsor lhs, Sponsor rhs) {
                            return lhs.getDisplayOrder()-rhs.getDisplayOrder();
                        }
                    });
                    result.addAll(groupByPackageTree.get(key));
                }

                if(getView() != null){
                    getView().updateSponsors(result);
                }
            }

            @Override public void onFailure(Exception pException) {
                if(getView() != null){
                    getView().onFailure();
                }
            }
        });
    }
}
