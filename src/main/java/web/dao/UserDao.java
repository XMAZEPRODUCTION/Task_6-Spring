package web.dao;

import web.model.User;

import java.util.List;
public interface UserDao {
    void create (User user);
    User getUserById (Long id);
    void update (Long id,User updateUser);
    void delete (Long id);
    List<User> getList();
}
