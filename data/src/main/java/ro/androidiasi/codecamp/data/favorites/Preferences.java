package ro.androidiasi.codecamp.data.favorites;

import org.androidannotations.annotations.sharedpreferences.SharedPref;

/**
 * Created by andrei on 10/04/16.
 */
@SharedPref
public interface Preferences {
    String favorites();
}
