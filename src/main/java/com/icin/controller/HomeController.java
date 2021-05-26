package com.icin.controller;

import java.security.Principal;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.icin.dao.RoleDao;
import com.icin.domain.PrimaryAccount;
import com.icin.domain.SavingsAccount;
import com.icin.domain.User;
import com.icin.domain.security.UserRole;
import com.icin.service.UserService;

@RestController
public class HomeController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
    private RoleDao roleDao;
	
	@RequestMapping("/")
	public ModelAndView home() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("index");
		return mav;
	}
	
	@RequestMapping("/index")
    public ModelAndView index() {
		ModelAndView mav = new ModelAndView("index");
        return mav;
    }
	
	@RequestMapping(value = "/signup", method = RequestMethod.GET)
    public ModelAndView signup(Model model) {
		ModelAndView mav = new ModelAndView("signup");
        User user = new User();

        model.addAttribute("user", user);

        return mav;
    }
	
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
    public ModelAndView signupPost(@ModelAttribute("user") User user,  Model model) {
		ModelAndView mav = new ModelAndView("signup");
		ModelAndView mav1 = new ModelAndView("index");

        if(userService.checkUserExists(user.getUsername(), user.getEmail()))  {

            if (userService.checkEmailExists(user.getEmail())) {
                model.addAttribute("emailExists", true);
            }

            if (userService.checkUsernameExists(user.getUsername())) {
                model.addAttribute("usernameExists", true);
            }

            return mav;
        } else {
        	 Set<UserRole> userRoles = new HashSet<>();
             userRoles.add(new UserRole(user, roleDao.findByName("ROLE_USER")));

            userService.createUser(user, userRoles);

            return mav1;
        }
    }
	
	@RequestMapping("/userFront")
	public ModelAndView userFront(Principal principal, Model model) {
		ModelAndView mav = new ModelAndView("userFront");
        User user = userService.findByUsername(principal.getName());
        PrimaryAccount primaryAccount = user.getPrimaryAccount();
        SavingsAccount savingsAccount = user.getSavingsAccount();

        model.addAttribute("primaryAccount", primaryAccount);
        model.addAttribute("savingsAccount", savingsAccount);

        return mav;
    }
}

