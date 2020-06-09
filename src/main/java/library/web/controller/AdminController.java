package library.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import library.web.entity.User;
import library.web.service.UserService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/page")
	public String admin() {
		return "admin-page";
	}
	
	@GetMapping("/showUsers")
	public String showUsers(Model model) {
		List<User> users = userService.getUsers();
		model.addAttribute("users", users);
		return "show-users";
	}
	
	@GetMapping("/deleteUser")
	public String deleteUser(@RequestParam("userId") long userId) {
		userService.deleteUser(userId);
		return "redirect:/admin/showUsers";
	}

}
