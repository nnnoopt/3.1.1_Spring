package com.nnnoopt.myworksboot.services;

import com.nnnoopt.myworksboot.dao.UserDaoHibernateImpl;
import com.nnnoopt.myworksboot.models.User;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserDaoHibernateImpl userDaoHibernate;

    public UserServiceImpl(UserDaoHibernateImpl userDaoHibernate) {
        this.userDaoHibernate = userDaoHibernate;
    }

    @Override
    public List<User> getUsers() {
        return userDaoHibernate.getUsers();
    }

    @Override
    public User readUser(long id) {
        return userDaoHibernate.readUser(id);
    }

    @Override
    public User deleteUser(long id) {
        User user = null;
        try {
            user = userDaoHibernate.deleteUser(id);
        } catch (EntityNotFoundException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public void createUser(User user) {
        userDaoHibernate.createUser(user);
    }

    @Override
    public void updateUser(User user) {
        userDaoHibernate.updateUser(user);
    }
}
