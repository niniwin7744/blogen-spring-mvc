package com.example.blogenspringmvc.service;

import com.example.blogenspringmvc.dao.UsersDao;
import com.example.blogenspringmvc.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UsersDao usersDao;
    public void saveUser(Users users){
        usersDao.save(users);
    }
    public List<Users> findAllUsers(){
        return usersDao.findAll();
    }

}
