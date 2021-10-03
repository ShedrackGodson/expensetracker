package com.expensetracker.expensetracker.services;

import com.expensetracker.expensetracker.exceptions.EtAuthException;
import com.expensetracker.expensetracker.models.User;
import com.expensetracker.expensetracker.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.regex.Pattern;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public User validateUser(String email, String password) throws EtAuthException {
        return null;
    }

    @Override
    public User registerUser(Integer id, String firstName, String lastName, String email, String password) throws EtAuthException {
        Pattern pattern = Pattern.compile("^(.+)@(.+)$");
        if(email != null) email = email.toLowerCase();

        assert email != null;
        if(!pattern.matcher(email).matches())
            throw new EtAuthException("Invalid email format.");

        Integer count = userRepository.getCountByEmail(email);
        if(count > 0)
            throw new EtAuthException("Email already in use.");
        return userRepository.findById(userRepository.create(id, firstName, lastName, email, password));
    }
}
