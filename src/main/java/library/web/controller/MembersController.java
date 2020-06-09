package library.web.controller;

import java.util.List;

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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import library.web.entity.Members;
import library.web.service.LibraryService;

@Controller
@RequestMapping("/members")
public class MembersController {

	@Autowired
	private LibraryService libraryService;
	
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}

	@GetMapping("/membersList")
	public String getMembersList(Model model) {
		List<Members> members = libraryService.getMembers();
		model.addAttribute("members", members);
		return "members-list";
	}

	@GetMapping("/addMemberForm")
	public String addMemberForm(Model model) {
		model.addAttribute("member", new Members());
		return "member-form-add";
	}

	@PostMapping("/saveMember")
	public String saveMember(@Valid @ModelAttribute("member") Members member, BindingResult br) {

		if (br.hasErrors()) {
			return "member-form-add";
		} else {

			libraryService.saveMember(member);
			return "redirect:/members/membersList";
		}
	}

	@GetMapping("/updateMemberForm")
	public String updateMemberForm(@RequestParam("memberId") int id, Model model) {
		Members member = libraryService.getMember(id);
		model.addAttribute("member", member);
		return "member-form-add";
	}

	@GetMapping("/delete")
	public String deleteMember(@RequestParam("memberId") int id) {
		libraryService.deleteMember(id);
		return "redirect:/members/membersList";
	}

}
