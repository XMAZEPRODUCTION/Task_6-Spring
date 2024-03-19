package web.dao;

import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
@Repository
public class UserDaoImpl implements UserDao{
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public void create(User user) {
        entityManager.persist(user);
    }

    @Override
    public User getUserById(Long id) {
        return entityManager.find(User.class,id);
    }

    @Override
    public void update(Long id,User updateUser) {
        User upUser = getUserById(id);
        upUser.setName(updateUser.getName());
        upUser.setLastName(updateUser.getLastName());
        upUser.setAge(updateUser.getAge());
        entityManager.merge(upUser);
    }

    @Override
    public void delete(Long id) {
        entityManager.createQuery("delete from User user where user.id=:id")
                .setParameter("id",id)
                .executeUpdate();


    }

    @Override
    public List<User> getList() {
        return entityManager.createQuery("from User").getResultList();
    }
}
