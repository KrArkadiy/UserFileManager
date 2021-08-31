package ru.krylosov.arkadiy.controller;

import ru.krylosov.arkadiy.model.User;
import ru.krylosov.arkadiy.service.UserService;

import java.util.List;

public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    public User getById(Long aLong){
        return userService.getById(aLong);
    }

    public List<User> getAll(){
        return userService.getAll();
    }

    public User save(User user){
        return userService.save(user);
    }

    public User update(User user){
        return userService.update(user);
    }

    public void deleteById(Long aLong){
        userService.deleteById(aLong);
    }
}
