package by.boiko.crm.controller;

import by.boiko.crm.model.Group;
import by.boiko.crm.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * The controller determines methods for access to Group service.
 */
@Controller
public class GroupController {

    @Autowired
    private GroupService groupService;

    /**
     * Returns list of all students.
     *
     * @return list of students
     */
    @RequestMapping(value = "/groups")
    public ModelAndView getAllGroups() {
        ModelAndView mv = new ModelAndView("listGroup");
        mv.addObject("groups", groupService.getAllGroup());
        mv.addObject("list",groupService.getAllGroup());
        return mv;
    }

    /**
     * Deletes a group by identifier.
     *
     * @param groupId identifier of a group to delete
     * @return refresh the page
     */
    @RequestMapping(value = "/group/{groupId}/delete", method = RequestMethod.GET )
    public String deleteGroup(@PathVariable("groupId") int groupId) {
        groupService.delete(groupId);
        ModelAndView mv = new ModelAndView("list");
        mv.addObject("groups", groupService.getAllGroup());
        return "redirect:/groups";
    }

    /**
     * Open the form of creation and updating a group.
     *
     * @return page with form
     */
    @RequestMapping(value = "/group/form")
    public ModelAndView openGroupForm() {
        ModelAndView mv = new ModelAndView("formGroup", "groupForm", new Group());
        mv.addObject("groupForm");
        return mv;
    }

    /**
     * Save a new student.
     *
     * @param group group object
     * @return to page with all students
     */
    @RequestMapping(value = "/group/", method = RequestMethod.POST)
    public String saveOrUpdateStudent(@ModelAttribute("groupForm") Group group) {
        groupService.saveOrUpdate(group);
        return "redirect:/groups";
    }
}
