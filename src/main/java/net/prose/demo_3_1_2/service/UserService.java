package net.prose.demo_3_1_2.service;

import net.prose.demo_3_1_2.model.User;

import java.util.List;

public interface UserService {
    public List<User> getUsers();

    public User saveUser(User user);

    public User getUser(Long id);

    public void deleteUser(Long id);
}


