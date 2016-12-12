package by.boiko.crm.controller;


import by.boiko.crm.model.User;
import by.boiko.crm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;

/**
 * The controller determines methods for access to User service.
 */

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

//    /**
//     * Returns list of all users.
//     *
//     * @return list of users
//     */
//    @RequestMapping(value = "user")
//    public ModelAndView getAllUsers() {
//        ModelAndView mv = new ModelAndView("list");
//        mv.addObject("users", userService.getAll());
//        mv.addObject("counts", userService.getAllCount());
//        return mv;
//    }

    /**
     * Deletes a user by identifier.
     *
     * @param userId identifier of a user to delete
     * @return refresh the page
     */
    @RequestMapping(value = "/{userId}/delete", method = RequestMethod.GET)
    public String deleteStudent(@PathVariable("userId") int userId) {
        userService.delete(userId);
        ModelAndView mv = new ModelAndView("list");
//        mv.addObject("users", userService.getAll());
        return "redirect:/user";
    }

    /**
     * Open the form of creation and updating a user.
     *
     * @return page with form
     */
    @RequestMapping(value = "/form")//TODO add method GET or POST
    public ModelAndView openUserEditForm() {
        return new ModelAndView("form", "userForm", new User());
    }

    /**
     * Save a new user.
     *
     * @return to page with all users
     */
    @RequestMapping(value = "/save/", method = RequestMethod.GET)
    public String saveOrUpdateStudent(@ModelAttribute("userForm") User user) {
        LocalDateTime localDateTime = LocalDateTime.now();
        user.setCreatedDate(localDateTime);
        userService.saveOrUpdate(user);
        return "redirect:/user";
    }


    /**
     * Update a user by identifier.
     *
     * @param id identifier of a user
     * @return form for update
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String getStudent(@PathVariable("id") int id, Model model) {
        User user = userService.get(id);
        userService.saveOrUpdate(user);
        model.addAttribute("userForm", user);
        return "form";
    }


    /**
     * Filter users named.
     *
     * @param searchText text for search
     * @return page with the filtered users
     */
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public ModelAndView searchStudentByName(@RequestParam(name = "searchText") String searchText) {
        ModelAndView mv = new ModelAndView("list");
        mv.addObject("users", userService.getUserByName(searchText));
        return mv;
    }

    @RequestMapping(value = "/getNum/{page}")
    public ModelAndView getNum(@PathVariable(value = "page") int page) {
        ModelAndView mv = new ModelAndView("list");
        mv.addObject("counts", userService.getAllCount());
        int maxResult = 10;
        mv.addObject("users", userService.getUsers(page, maxResult));
        return mv;
    }
}
