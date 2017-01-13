package by.boiko.crm.service;


import by.boiko.crm.model.User;

import java.util.List;

/**
 * The interface determines the methods for work with User.
 */
public interface UserService {

    /**
     * Loads list of all users.
     *
     * @return list of users
     */
    List<User> getAll();

    /**
     * Loads a user by id.
     *
     * @param id identifier of a user
     * @return a user
     */
    User get(int id);

    /**
     * Deletes a user by id.
     *
     * @param id identifier of a user
     */
    void delete(int id);

    /**
     * Saves a user.
     *
     * @param user user object to saveOrUpdate
     */
    void saveOrUpdate(User user);

    /**
     * Loads list of users filtered by name.
     *
     *
     * @param page
     * @param maxResult
     *@param name name of a student for searching  @return list of searched users
     */
    List<User> getUserByName(int page, int maxResult, String name);

    List<User> getUsers(int value, int maxResult);

    long getAllCount();
}
