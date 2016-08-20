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
        mv.addObject("groups", groupService.getAll());
        mv.addObject("list",groupService.allGroup());
        return mv;
    }

    @RequestMapping(value = "/group/{groupId}/delete", method = RequestMethod.GET )
    public String deleteGroup(@PathVariable("groupId") int groupId) {
        groupService.delete(groupId);
        ModelAndView mv = new ModelAndView("list");
        mv.addObject("groups", groupService.getAll());
        return "redirect:/groups";
    }

    @RequestMapping(value = "/group/form")
    public ModelAndView openGroupForm() {
        ModelAndView mv = new ModelAndView("formGroup", "groupForm", new Group());
        mv.addObject("groupForm");
        return mv;
    }

    @RequestMapping(value = "/group/", method = RequestMethod.POST)
    public String saveOrUpdateStudent(@ModelAttribute("groupForm") Group group) {
        groupService.saveOrUpdate(group);
        return "redirect:/students";
    }
}
