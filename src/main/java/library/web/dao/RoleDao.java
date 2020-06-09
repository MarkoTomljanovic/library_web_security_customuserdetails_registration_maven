package library.web.dao;

import library.web.entity.Role;

public interface RoleDao {

	public Role findRoleByName(String theRoleName);
	
}
