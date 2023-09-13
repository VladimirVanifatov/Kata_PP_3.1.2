package ru.vanifatov.springbootproject.dao;


import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.vanifatov.springbootproject.models.User;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    private final EntityManager entityManager;

    @Autowired
    public UserDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<User> index() {
        return entityManager.createQuery("from User", User.class).getResultList();
    }


    public User show(int id) {
        return entityManager.find(User.class, id);
    }

    public void save(User user) {
        entityManager.persist(user);
    }

    public void update(int id, User updatedUser) {
        updatedUser.setId(id);
        entityManager.merge(updatedUser);
    }

    public void delete(int id) {
        entityManager.remove(entityManager.find(User.class, id));
    }
}
