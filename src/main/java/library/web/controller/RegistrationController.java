package library.web.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import library.web.entity.User;
import library.web.service.UserService;
import library.web.user.WebUser;

@Controller
@RequestMapping("/register")
public class RegistrationController {
	
	@Autowired
	private UserService userService;
	
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}
	
	@GetMapping("/showRegistrationForm")
	public String registrationForm(Model model) {
		model.addAttribute("webUser", new WebUser());
		return "registration-form";
	}
	
	@PostMapping("/processRegistrationForm")
	public String processRegistrationForm(@Valid @ModelAttribute("webUser") WebUser user, BindingResult br, Model model) {
		
		String userName = user.getUserName();
	
		if(br.hasErrors()) {
			return "registration-form";
		}
		
		User existingUser = userService.findByUserName(userName);
		if(existingUser != null) {
			model.addAttribute("registrationError", "User name already exists.");
			return "registration-form";
		}
		
		userService.save(user);
		
		return "registration-confirmation";
	}

}
