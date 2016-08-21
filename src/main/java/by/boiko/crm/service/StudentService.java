package by.boiko.crm.service;


import by.boiko.crm.model.Group;
import by.boiko.crm.model.Student;

import java.util.List;

/**
 * The interface determines the methods for work with Student.
 */
public interface StudentService {

    /**
     * Loads list of all students.
     *
     * @return list of students
     */
    List<Student> getAll();

    /**
     * Loads a student by id.
     *
     * @param id identifier of a student
     * @return a student
     */
    Student get(int id);

    /**
     * Deletes a student by id.
     *
     * @param id identifier of a student
     */
    void delete(int id);

    /**
     * Saves a student.
     *
     * @param student student object to saveOrUpdate
     */
    void saveOrUpdate(Student student);

    /**
     * Loads list of students filtered by name.
     *
     * @param name name of a student for searching
     * @return list of searched students
     */
    List getStudentByName(String name);
}
