package by.boiko.crm.service;


import by.boiko.crm.model.Group;
import by.boiko.crm.model.Student;

import java.util.List;

/**
 * The interface determines the methods for work with Group.
 */
public interface GroupService {

    /**
     * Deletes a group by id.
     *
     * @param id identifier of a group
     */
    void delete(int id);

    /**
     * Saves a group.
     *
     * @param group group object to saveOrUpdate
     */
    void saveOrUpdate(Group group);

    /**
     * Loads list of all groups.
     *
     * @return list of groups
     */
    List<Group> getAllGroup();
}
