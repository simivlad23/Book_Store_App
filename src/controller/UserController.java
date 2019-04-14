package controller;

import service.UserService;
import view.UserView;

public class UserController {
    private UserView userView;
    private UserService userService;

    public UserController(UserView userView, UserService userService) {
        this.userView = userView;
        this.userService = userService;
    }
}
