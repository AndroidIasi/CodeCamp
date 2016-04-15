package ro.androidiasi.codecamp.data.model;

import java.io.Serializable;

/**
 * Created by andrei on 06/04/16.
 */
public interface IDataModel<Id> extends Serializable {
    Id getId();
}
