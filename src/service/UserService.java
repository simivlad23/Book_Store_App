package service;

import model.User;

public interface UserService {

    User save(User user);

    void delete(Long id);

    User login(String username, String password);
}
