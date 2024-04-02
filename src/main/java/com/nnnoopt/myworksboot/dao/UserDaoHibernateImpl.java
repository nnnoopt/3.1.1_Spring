package com.nnnoopt.myworksboot.dao;

import com.nnnoopt.myworksboot.models.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class UserDaoHibernateImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getUsers() {
        return entityManager.createQuery("from User", User.class).getResultList();
    }

    @Override
    public void createUser(User user) {
        entityManager.persist(user);
        entityManager.flush();
    }

    @Override
    public User readUser(long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void updateUser(User user) {
        entityManager.merge(user);
        entityManager.flush();
    }

    @Override
    public User deleteUser(long id) throws EntityNotFoundException {
        User user = readUser(id);
        if (user == null) {
            throw new EntityNotFoundException("Пользователь не найден");
        }
        entityManager.remove(user);
        entityManager.flush();
        return user;
    }
}
