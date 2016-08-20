package by.boiko.crm.converters;

import by.boiko.crm.model.Student;
import by.boiko.crm.model.StudentViewModel;

/**
 * Created by ERIZO on 21.08.2016.
 */
public class StudentToStudentVewModelConverter {


    public StudentViewModel convert(Student student) {
        StudentViewModel studentViewModel = new StudentViewModel();
        studentViewModel.setId(student.getId());
        studentViewModel.setFullName(student.getFullName());
        studentViewModel.setNumberGroup(student.getNumberGroup());
        return studentViewModel;
    }
}
