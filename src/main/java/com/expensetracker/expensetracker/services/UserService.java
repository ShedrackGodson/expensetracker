package com.expensetracker.expensetracker.services;

import com.expensetracker.expensetracker.exceptions.EtAuthException;
import com.expensetracker.expensetracker.models.User;

public interface UserService {

    // validate user: return a user
    User validateUser(String email, String password) throws EtAuthException;

    // register a new user: return a user
    User registerUser(Integer id, String firstName, String lastName, String email, String password) throws EtAuthException;


}
