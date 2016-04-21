package ro.androidiasi.codecamp.data.source.local;

import com.snappydb.SnappydbException;

import ro.androidiasi.codecamp.data.model.DataCodecamp;

/**
 * Created by andrei on 21/04/16.
 */
public interface IDatabase {
    boolean dataExists() throws SnappydbException;

    void saveCodecamp(DataCodecamp pCodecamp) throws SnappydbException;

    DataCodecamp getCodecamp() throws SnappydbException;

    boolean isFavorite(Long pDataSessionId) throws SnappydbException;

    void setSessionFavorite(Long pLong, boolean pIsFavorite) throws SnappydbException;

    void deleteCodecamp();
}
