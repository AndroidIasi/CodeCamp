package ro.androidiasi.codecamp.data.source.local.exception;

import com.snappydb.SnappydbException;

/**
 * Created by andrei on 21/04/16.
 */
public class UnsupportedSnappyDb extends SnappydbException {
    public UnsupportedSnappyDb() {
        super("Apparently snappyDb can't run on your device :(");
    }
}
