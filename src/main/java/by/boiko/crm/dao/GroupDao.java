package by.boiko.crm.dao;


import by.boiko.crm.model.Group;
import by.boiko.crm.model.Student;

import java.util.List;

public interface GroupDao {

    List<Group> loadAll();

    void delete(int id);

    void saveOrUpdate(Group group);//TODO change name

    Group load(int id);

    /**
     * Loads list of all groups from a storage.
     *
     * @return list of groups
     */
    List<Group> allGroup(); // TODO replace metod and rename
}
