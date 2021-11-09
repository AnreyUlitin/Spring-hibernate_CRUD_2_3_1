package website.dao;

import org.springframework.stereotype.Repository;
import website.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public void updateUser(User user) {
        entityManager.merge(user);
    }

    @Override
    public void deleteUserById(Long id) {
        entityManager.remove(entityManager.find(User.class, id));
    }

    @Override
    public User getUserById(Long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("SELECT u FROM User u", User.class).getResultList();
    }
}











//import website.model.User;
//import org.springframework.stereotype.Component;
//import java.util.List;
//import javax.persistence.PersistenceContext;
//import javax.persistence.EntityManager;
//import org.springframework.stereotype.Repository;
//
//
//@Component
//@Repository
//public class UserDaoImpl implements UserDao {
//
//    @PersistenceContext
//    private EntityManager entityManager;
//
//    @Override
//    public void addUser(User user) {
//        entityManager.persist(user);
//    }
//
//    @Override
//    public void updateUser(User user) {
//        entityManager.merge(user);
//    }
//
//    @Override
//    public void removeUser(int id) {
//        User user = entityManager.find(User.class, id);
//        if (user != null) {
//            entityManager.remove(user);
//        }
//    }
//
//    @Override
//    public User getUserById(int id) {
//        return entityManager.find(User.class, id);
//    }
//
//    @Override
//    public List<User> listUsers() {
//
//        return entityManager.createQuery("from User", User.class).getResultList();
//        //return entityManager.createQuery("select u from User u", User.class)
//                //.getResultList();
//    }
//
//}
