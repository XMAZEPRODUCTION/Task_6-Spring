package web.service;

import org.springframework.stereotype.Service;
import web.model.User;

import java.util.List;

public interface UserService {
    void create (User user);
    User getUserById (Long id);
    void update (Long id,User updateUser);
    void delete (Long id);
    List<User> getList();
}
