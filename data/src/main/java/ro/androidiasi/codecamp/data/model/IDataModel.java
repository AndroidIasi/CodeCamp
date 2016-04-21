package ro.androidiasi.codecamp.data.model;

/**
 * Created by andrei on 06/04/16.
 */
public interface IDataModel<Id> {
    void setId(Id pId);
    Id getId();
}
