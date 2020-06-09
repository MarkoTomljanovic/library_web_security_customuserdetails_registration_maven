package library.web.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import library.web.entity.Role;



@Repository
public class RoleDaoImpl implements RoleDao {


	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Role findRoleByName(String roleName) {

		Session session = sessionFactory.getCurrentSession();
		
		Role role = null;
		try {
			role = (Role) session.createQuery("from Role where name = :name").setParameter("name", roleName).getSingleResult();
		} catch (Exception e) {
			role = null;
		}
		
		return role;
	}
}
