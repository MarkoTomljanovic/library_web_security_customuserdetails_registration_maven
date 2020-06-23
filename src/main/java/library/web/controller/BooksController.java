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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import library.web.entity.Books;
import library.web.service.LibraryService;

@Controller
@RequestMapping("/books")
public class BooksController {

	@Autowired
	private LibraryService libraryService;
	
	//check for spaces in fields for book details
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}

	@GetMapping("/booksList")
	public String booksList(Model model) {
		List<Books> books = libraryService.getBooks();
		model.addAttribute("books", books);
		return "books-list";
	}

	@GetMapping("/updateBookForm")
	public String updateBookForm(@RequestParam("bookId") int id, Model model) {
		Books book = libraryService.getBook(id);
		model.addAttribute("book", book);
		return "book-form-add";
	}

	@GetMapping("/deleteBook")
	public String deleteBook(@RequestParam("bookId") int id) {
		libraryService.deleteBook(id);
		return "redirect:/books/booksList";
	}

	//before saving, data is validated
	@PostMapping("/saveBook")
	public String saveBook(@Valid @ModelAttribute("book") Books book, BindingResult br) {

		if (br.hasErrors()) {
			return "book-form-add";
		} else {

			libraryService.saveBook(book);
			return "redirect:/books/booksList";
		}
	}

	@GetMapping("/addBookForm")
	public String addBookForm(Model model) {
		model.addAttribute("book", new Books());
		return "book-form-add";
	}

}
