package by.boiko.crm.dao;


import by.boiko.crm.model.Group;
import by.boiko.crm.model.Student;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * The interface determines the basic methods of access to the database.
 */
@Service
public interface GroupDao {

    /**
     * Deletes a group from a storage by id.
     *
     * @param id identifier of a group to delete
     */
    void delete(int id);

    /**
     * Saves a group into a storage.
     *
     * @param group groups object to saveOrUpdate
     */
    void saveOrUpdate(Group group);//TODO change name

    /**
     * Loads list of all groups from a storage.
     *
     * @return list of groups
     */
    List<Group> getAllGroup(); // TODO replace metod and rename
}
