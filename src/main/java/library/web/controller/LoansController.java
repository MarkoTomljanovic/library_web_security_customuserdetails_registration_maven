package library.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import library.web.entity.Books;
import library.web.entity.Members;
import library.web.service.LibraryService;

@Controller
@RequestMapping("/loans")
public class LoansController {

	@Autowired
	private LibraryService libraryService;

	@GetMapping("/list")
	public String getMembers(Model model) {
		List<Members> members = libraryService.getMembers();
		model.addAttribute("members", members);
		return "members-loans-list";
	}


	@GetMapping("/membersLoans")
	public String membersLoans(@RequestParam("memberId") int id, Model model) {
		Members member = libraryService.getMember(id);
		model.addAttribute("memberLoans", member);
		List<Books> books = libraryService.getBooksNoMembers();
		model.addAttribute("booksnomembers", books);
		return "loans-list";
	}

	@GetMapping("/returnBook")
	public String returnBook(@RequestParam("bookId") int id, RedirectAttributes redirectAttributes) {

		Books book = libraryService.getBook(id);
		int memberId = book.getMembers().getId();

		libraryService.returnBook(id);
		Members member = libraryService.getMember(memberId);

		redirectAttributes.addAttribute("memberId", memberId);
		return "redirect:/loans/membersLoans";
	}



	@GetMapping("/loanBook")
	public String loanBook(@RequestParam("bookId") int id, @RequestParam("memberId") int id2,
			RedirectAttributes redirectAttributes) {
		libraryService.loanBook(id, id2);
		redirectAttributes.addAttribute("memberId", id2);
		return "redirect:/loans/membersLoans";
	}

}
