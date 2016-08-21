package by.boiko.crm.converters;

import by.boiko.crm.model.Student;
import by.boiko.crm.model.StudentViewModel;

/**
 * Convert student to student view model.
 */
public class StudentToStudentVewModelConverter {

    /**
     *
     * @param student student object
     * @return student object
     */
    public StudentViewModel convert(Student student) {
        StudentViewModel studentViewModel = new StudentViewModel();
        studentViewModel.setId(student.getId());
        studentViewModel.setFullName(student.getFullName());
        studentViewModel.setNumberGroup(student.getNumberGroup());
        return studentViewModel;
    }
}
