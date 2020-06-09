package library.web.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import library.web.entity.Books;
import library.web.entity.Members;

@Repository
public class LibraryDAOImpl implements LibraryDAO {
	
	@Autowired
	@Qualifier("session")
	private SessionFactory sessionFactory;

	@Override
	public List<Members> getMembers() {
		Session session = sessionFactory.getCurrentSession();
		List<Members> members = session.createQuery("from Members as m left join fetch m.books").getResultList();
		return members;
	}

	@Override
	public void deleteMember(int id) {
		Session session = sessionFactory.getCurrentSession();
		Members member = session.get(Members.class, id);
		session.delete(member);		
	}

	@Override
	public void saveMember(Members member) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(member);
	}

	@Override
	public Members getMember(int id) {
		Session session = sessionFactory.getCurrentSession();
		Members member = (Members)session.createQuery("from Members as m left join fetch m.books where m.id = :id").setParameter("id", id).getSingleResult();
		return member;		
	}

	@Override
	public void returnBook(int id) {
		Session session = sessionFactory.getCurrentSession();
		Books book = session.get(Books.class, id);
		book.setMembers(null);
	}

	@Override
	public Books getBook(int id) {
		Session session = sessionFactory.getCurrentSession();
		Books book = session.get(Books.class, id);
		return book;
	}

	@Override
	public List<Books> getBooks() {
		Session session = sessionFactory.getCurrentSession();
		List<Books> books = session.createQuery("from Books").getResultList();
		return books;
	}

	@Override
	public void saveBook(Books book) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(book);
		
	}

	@Override
	public void deleteBook(int id) {
		Session session = sessionFactory.getCurrentSession();
		Books book = session.get(Books.class, id);
		session.delete(book);	
		
	}
	
	@Override
	public List<Books> getBooksNoMembers() {
		Session session = sessionFactory.getCurrentSession();
		List<Books> books = session.createQuery("from Books where id_member is null").getResultList();
		return books;
	}

	@Override
	public void loanBook(int id, int id2) {
		Session session = sessionFactory.getCurrentSession();
		Books book = (Books) session.createQuery("from Books where id = :id").setParameter("id",id).getSingleResult();
		Members member = (Members) session.createQuery("from Members as m left join fetch m.books where m.id = :id").setParameter("id", id2).getSingleResult();
		member.addBooks(book);
	}

}
