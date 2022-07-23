package ru.work.forum.service;

import org.springframework.stereotype.Service;
import ru.work.forum.model.User;
import ru.work.forum.persistence.UserStore;

@Service
public class UserService {

    private final UserStore userStore;

    public UserService(UserStore userStore) {
        this.userStore = userStore;
    }
    public void save(User user) {
        userStore.save(user);
    }

    public User findById(int id) {
        return userStore.findById(id);
    }

    public User findByUsername(String username) {
        return userStore.findByUsername(username);
    }
}
