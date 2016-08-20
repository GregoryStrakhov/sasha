package by.boiko.crm.controller;


import by.boiko.crm.converters.StudentToStudentVewModelConverter;
import by.boiko.crm.converters.StudentViewModelToStudentConverter;
import by.boiko.crm.model.Student;
import by.boiko.crm.model.StudentViewModel;
import by.boiko.crm.service.GroupService;
import by.boiko.crm.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * The controller determines methods for access to Student service.
 */
@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private GroupService groupService;

    /**
     * Returns list of all students.
     *
     * @return list of students
     */
    @RequestMapping(value = "/students")
    public ModelAndView getAllStudents() {
        ModelAndView mv = new ModelAndView("list");
        mv.addObject("students", studentService.getAll());
        return mv;
    }

    /**
     * Deletes a student by identifier.
     *
     * @param studentId identifier of a student to delete
     * @return refresh the page
     */
    @RequestMapping(value = "/student/{studentId}/delete", method = RequestMethod.GET )
    public String deleteStudent(@PathVariable("studentId") int studentId) {
        studentService.delete(studentId);
        ModelAndView mv = new ModelAndView("list");
        mv.addObject("students", studentService.getAll());
        return "redirect:/students";
    }

    /**
     * Open the form of creation and updating a student.
     *
     * @return page with form
     */
    @RequestMapping(value = "/student/form")//TODO add method GET or POST
    public ModelAndView openStudentEditForm() {
        ModelAndView mv = new ModelAndView("form", "studentForm", new StudentViewModel());
        mv.addObject("studentForm");
        mv.addObject("list",groupService.allGroup());
        return mv;
    }

    @RequestMapping(value = "/student/", method = RequestMethod.POST) //TODO saveOrUpdate a new student and @Link
    public String saveOrUpdateStudent(@ModelAttribute("studentForm") StudentViewModel studentViewModel) {
        StudentViewModelToStudentConverter studentViewModelToStudentConverter = new StudentViewModelToStudentConverter();
        Student student = studentViewModelToStudentConverter.convert(studentViewModel) ;
        studentService.saveOrUpdate(student);
        return "redirect:/students";
    }

    /**
     *
     * @param studentId identifier of a student
     * @param model
     * @return form for update
     */
    @RequestMapping(value = "/student/{studentId}", method = RequestMethod.GET)//TODO Update student
    public String getStudent(@PathVariable("studentId") int studentId, Model model, @RequestParam("mode") String mode) {
        StudentToStudentVewModelConverter studentToStudentVewModelConverter = new StudentToStudentVewModelConverter();
        Student student = studentService.get(studentId);
        StudentViewModel studentViewModel = studentToStudentVewModelConverter.convert(student);
        model.addAttribute("mode", mode);
        model.addAttribute("studentForm", studentViewModel);
        model.addAttribute("list", groupService.allGroup());
        return "form";
    }

    /**
     *
     * @param searchText
     * @return
     */
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public ModelAndView searchStudentByName(@RequestParam(name = "searchText") String searchText) { //TODO change "searchText" "name"
        ModelAndView mv = new ModelAndView("list");
        mv.addObject("students", studentService.getStudentByName(searchText));
        return mv;
    }
}