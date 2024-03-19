package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDao;
import web.model.User;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    UserDao userDao;
    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    @Transactional
    public void create(User user) {
        userDao.create(user);
    }

    @Override
    public User getUserById(Long id) {
        return userDao.getUserById(id);
    }

    @Override
    @Transactional
    public void update(Long id, User updateUser) {
        userDao.update(id,updateUser);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        userDao.delete(id);

    }

    @Override
    public List<User> getList() {
        return userDao.getList();
    }
}
