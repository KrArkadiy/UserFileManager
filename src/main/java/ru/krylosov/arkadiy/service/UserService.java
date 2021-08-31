package ru.krylosov.arkadiy.service;

import ru.krylosov.arkadiy.dao.UserDao;
import ru.krylosov.arkadiy.dao.daoImplementation.UserDaoImpl;
import ru.krylosov.arkadiy.model.User;

import java.util.List;

public class UserService {

    private final UserDao userDao;

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public User getById(Long aLong){
        return userDao.getById(aLong);
    }

    public List<User> getAll(){
        return userDao.getAll();
    }

    public User save(User user){
        return userDao.save(user);
    }

    public User update(User user){
        return userDao.update(user);
    }

    public void deleteById(Long aLong){
        userDao.deleteById(aLong);
    }
}
