package com.nnnoopt.myworksboot.services;

import com.nnnoopt.myworksboot.models.User;

import java.util.List;

public interface UserService {
    List<User> getUsers();

    User readUser(long id);

    User deleteUser(long parseUnsignedInt);

    void createUser(User user);

    void updateUser(User user);
}
