package web.dao;


import web.model.User;

import java.util.List;

public interface UserDao {

    List<User> getUsers();

    public void saveUser(User user);

    public User getUser(Long id);

    public void deleteUser(Long id);
}
