package ru.vanifatov.springbootproject.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.vanifatov.springbootproject.dao.UserDao;
import ru.vanifatov.springbootproject.models.User;


import java.util.List;

@Service
public class UserServiceImpl implements UserService {


    private final UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Transactional(readOnly = true)
    public List<User> index() {
        return userDao.index();
    }

    @Transactional(readOnly = true)
    public User show(int id) {
        return userDao.show(id);

    }
    @Transactional
    public void save(User user) {
        userDao.save(user);
    }

    @Transactional
    public void update(int id, User updatedUser) {
        userDao.update(id, updatedUser);

    }
    @Transactional
    public void delete(int id) {
        userDao.delete(id);
    }
}
