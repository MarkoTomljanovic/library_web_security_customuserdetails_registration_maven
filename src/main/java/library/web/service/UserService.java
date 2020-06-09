package library.web.service;


import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import library.web.entity.User;
import library.web.user.WebUser;

public interface UserService extends UserDetailsService {

   public User findByUserName(String userName);

    public void save(WebUser crmUser);
    
    public List<User> getUsers();

	public void deleteUser(long userId);
}
