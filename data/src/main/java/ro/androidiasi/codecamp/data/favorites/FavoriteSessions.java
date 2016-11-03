package ro.androidiasi.codecamp.data.favorites;

import android.content.Context;
import android.content.SharedPreferences;

import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by andrei on 10/04/16.
 */
@EBean
public class FavoriteSessions {

    public static final String PREFS_NAME = FavoriteSessions.class.getName();

    @RootContext Context mContext;

    private HashMap<String, Boolean> mValuesMap;

    public FavoriteSessions() {
        this.mValuesMap = new HashMap<>();
    }

    @AfterInject public void afterMembersInject() {
        this.updateFromPreferences();
    }

    public <Id> Boolean isFavorite(Id pId) {
        Boolean existingValue = this.mValuesMap.get(pId.toString());
        return existingValue == null ? Boolean.FALSE : existingValue;
    }

    public <Id> Boolean put(Id pId, Boolean pIsFavorite) {
        Boolean oldValue = this.mValuesMap.put(pId.toString(), pIsFavorite);
        this.save();
        return oldValue;
    }

    public void save() {
        SharedPreferences.Editor editor = this.mContext.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE).edit();
        for(Map.Entry entry : mValuesMap.entrySet()) {
            editor.putString(entry.getKey().toString(), entry.getValue().toString());
        }
        editor.apply();
    }

    public void updateFromPreferences() {
        SharedPreferences sharedPreferences = this.mContext.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        for(Map.Entry entry : sharedPreferences.getAll().entrySet()) {
            this.mValuesMap.put(entry.getKey().toString(), Boolean.parseBoolean(entry.getValue().toString()));
        }
    }
}
