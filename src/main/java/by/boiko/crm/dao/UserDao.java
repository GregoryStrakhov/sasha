package by.boiko.crm.dao;


import by.boiko.crm.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * The interface determines the basic methods of access to the database.
 */
@Service
public interface UserDao {

    /**
     * Loads list of all users from storage.
     *
     * @return list of users
     */
    List<User> loadAll();

    /**
     * Loads list of users filtered by name.
     *
     *
     * @param page
     * @param maxResult
     *@param name name of a user for searching  @return list of searched users
     */
    List<User> loadUserByName(int page, int maxResult, String name);

    /**
     * Deletes a user from a storage by id.
     *
     * @param id identifier of a user to delete
     */
    void delete(int id);

    /**
     * Saves a user into a storage.
     *
     * @param user user object to saveOrUpdate
     */
    void saveOrUpdate(User user);//TODO change name

    /**
     * Loads a user from a storage by id.
     *
     * @param id identifier of a user
     * @return a user
     */
    User load(int id);

    List<User> loadUsers(int value, int maxResult);

    long loadAllCount();
}
