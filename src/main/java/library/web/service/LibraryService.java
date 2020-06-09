package library.web.service;

import java.util.List;

import library.web.entity.Books;
import library.web.entity.Members;

public interface LibraryService {
	public List<Members> getMembers();
	public void deleteMember(int id);
	public void saveMember(Members member);
	public Members getMember(int id);
	public void returnBook(int id);
	public Books getBook(int id);
	public List<Books> getBooks();
	public void saveBook(Books book);
	public void deleteBook(int id);
	public List<Books> getBooksNoMembers();
	public void loanBook(int id, int id2);
}
