package website.service;

import website.model.User;
import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    User getUserById(Long id);

    void addUser(User user);

    void updateUser(User user);

    void deleteUserById(Long id);

}

