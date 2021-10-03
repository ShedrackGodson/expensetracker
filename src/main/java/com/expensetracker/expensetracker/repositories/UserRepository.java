package com.expensetracker.expensetracker.repositories;


import com.expensetracker.expensetracker.exceptions.EtAuthException;
import com.expensetracker.expensetracker.models.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository {

    // create user: return user id
    Integer create(String firstName, String lastName) throws EtAuthException;

    // find user by email and password: return User if found, otherwise throws Exception
    User findByEmailAndPassword(String email, String password) throws EtAuthException;

    // find user by id: return User if found, otherwise throws Exception
    User findById(Integer userId) throws EtAuthException;

    Integer getCountByEmail(String email);

    Integer create(Integer id, String firstName, String lastName, String email, String password);

    User getUserById(Integer userId);
}
