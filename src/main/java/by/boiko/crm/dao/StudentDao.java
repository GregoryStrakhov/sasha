package by.boiko.crm.dao;


import by.boiko.crm.model.Group;
import by.boiko.crm.model.Student;

import java.util.List;

/**
 * The interface determines the basic methods of access to the database.
 */
public interface StudentDao {

    /**
     * Loads list of all students from storage.
     *
     * @return list of students
     */
    List<Student> loadAll();

    /**
     * Loads list of students filtered by name.
     *
     * @param name name of a student for searching
     * @return list of searched students
     */
    List loadStudentsByName(String name);

    /**
     * Deletes a student from a storage by id.
     *
     * @param id identifier of a student to delete
     */
    void delete(int id);

    /**
     * Saves a student into a storage.
     *
     * @param student student object to saveOrUpdate
     */
    void saveOrUpdate(Student student);//TODO change name

    /**
     * Loads a student from a storage by id.
     *
     * @param id identifier of a student
     * @return a student
     */
    Student load(int id);
}
