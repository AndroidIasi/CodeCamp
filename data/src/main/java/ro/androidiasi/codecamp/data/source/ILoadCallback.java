package ro.androidiasi.codecamp.data.source;

/**
 * Created by andrei on 06/04/16.
 */
public interface ILoadCallback<T> {
    void onSuccess(T pObject);
    void onFailure(Exception pException);
}
