package ro.androidiasi.codecamp.data.source.local.exception;

import com.snappydb.SnappydbException;

/**
 * Created by andrei on 21/04/16.
 */
public class DataNotFoundException extends SnappydbException {
    public DataNotFoundException() {
        super("No Data found in store :(");
    }
}
