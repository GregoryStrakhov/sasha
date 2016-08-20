package by.boiko.crm.service;


import by.boiko.crm.model.Group;
import by.boiko.crm.model.Student;

import java.util.List;

public interface GroupService {

    /**
     *
     * @return
     */
    List<Group> getAll();

    /**
     *
     * @param id
     * @return
     */
    Group get(int id);

    /**
     *
     * @param id
     */
    void delete(int id);

    /**
     *
     * @param group
     */
    void saveOrUpdate(Group group);

    /**
     *
     * @return
     */
    List<Group> allGroup();
}
