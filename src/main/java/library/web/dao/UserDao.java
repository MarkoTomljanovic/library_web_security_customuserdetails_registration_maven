package library.web.dao;

import java.util.List;

import library.web.entity.User;

public interface UserDao {

	public User findByUserName(String userName);

	public void save(User user);

	public List<User> getUsers();

	public void deleteUser(long userId);

}
