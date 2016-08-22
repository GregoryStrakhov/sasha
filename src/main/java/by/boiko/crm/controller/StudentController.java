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
@RequestMapping(value = "/student")
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
    @RequestMapping(value = "/all")
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
    @RequestMapping(value = "/{studentId}/delete", method = RequestMethod.GET )
    public String deleteStudent(@PathVariable("studentId") int studentId) {
        studentService.delete(studentId);
        ModelAndView mv = new ModelAndView("list");
        mv.addObject("students", studentService.getAll());
        return "redirect:/student/all";
    }

    /**
     * Open the form of creation and updating a student.
     *
     * @return page with form
     */
    @RequestMapping(value = "/form")
    public ModelAndView openStudentEditForm() {
        ModelAndView mv = new ModelAndView("form", "studentForm", new StudentViewModel());
        mv.addObject("studentForm");
        mv.addObject("list",groupService.getAllGroup());
        return mv;
    }

    /**
     * Save a new student.
     *
     * @param studentViewModel converter
     * @return to page with all students
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveOrUpdateStudent(@ModelAttribute("studentForm") StudentViewModel studentViewModel) {
        StudentViewModelToStudentConverter studentViewModelToStudentConverter = new StudentViewModelToStudentConverter();
        Student student = studentViewModelToStudentConverter.convert(studentViewModel) ;
        studentService.saveOrUpdate(student);
        return "redirect:/student/all";
    }

    /**
     * Update a student by identifier.
     *
     * @param studentId identifier of a student
     * @return form for update
     */
    @RequestMapping(value = "/{studentId}", method = RequestMethod.GET)
    public String getStudent(@PathVariable("studentId") int studentId, Model model, @RequestParam("mode") String mode) {
        StudentToStudentVewModelConverter studentToStudentVewModelConverter = new StudentToStudentVewModelConverter();
        Student student = studentService.get(studentId);
        StudentViewModel studentViewModel = studentToStudentVewModelConverter.convert(student);
        model.addAttribute("mode", mode);
        model.addAttribute("studentForm", studentViewModel);
        model.addAttribute("list", groupService.getAllGroup());
        return "form";
    }

    /**
     * Filter students named.
     *
     * @param searchText text for search
     * @return page with the filtered students
     */
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public ModelAndView searchStudentByName(@RequestParam(name = "searchText") String searchText) {
        ModelAndView mv = new ModelAndView("list");
        mv.addObject("students", studentService.getStudentByName(searchText));
        return mv;
    }
}