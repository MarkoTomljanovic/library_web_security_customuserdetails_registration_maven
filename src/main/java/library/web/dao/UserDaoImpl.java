package library.web.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import library.web.entity.Role;
import library.web.entity.User;



@Repository
public class UserDaoImpl implements UserDao {


	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public User findByUserName(String userName) {

		Session session = sessionFactory.getCurrentSession();
		
		User user = null;
		try {
			user = (User) session.createQuery("from User where userName = :userName").setParameter("userName", userName).getSingleResult();
		} catch (Exception e) {
			
			user = null;
		}

		return user;
	}

	@Override
	public void save(User user) {

		Session session = sessionFactory.getCurrentSession();

		session.saveOrUpdate(user);
	}

	@Override
	public List<User> getUsers() {
		Session session = sessionFactory.getCurrentSession();
		
		List<User> users = session.createQuery("from User as u inner join fetch u.roles ").getResultList();
		
		return users;
	}

	@Override
	public void deleteUser(long userId) {
		Session session = sessionFactory.getCurrentSession();
		
		User user = session.get(User.class, userId);
		user.setRoles(null);
		session.delete(user);
		
	}

}
