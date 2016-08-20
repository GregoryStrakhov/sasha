package by.boiko.crm.converters;

import by.boiko.crm.model.Group;
import by.boiko.crm.model.Student;
import by.boiko.crm.model.StudentViewModel;

/**
 *
 */
public class StudentViewModelToStudentConverter {
    /**
     *
     *
     * @param studentViewModel view model of a student
     * @return student object
     */
    public Student convert(StudentViewModel studentViewModel) {
        Student student = new Student();
        Group group = new Group();
        student.setId(studentViewModel.getId());
        student.setFullName(studentViewModel.getFullName());
        group.setNumberGroup(studentViewModel.getNumberGroup());
        group.setId(studentViewModel.getIdGroup());
        student.setGroup(group);
        return student;
    }
}
