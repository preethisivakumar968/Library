package com.library.library.repositories;

import java.util.ArrayList;
import java.util.List;

import javax.xml.crypto.Data;

import org.springframework.stereotype.Repository;

import com.library.library.dataRetrival.DataStoreAndRetrive;
import com.library.library.dataStorage.UsersData;
import com.library.library.entity.Borrower;
import com.library.library.entity.User;

@Repository
public class UsersRepository {

    DataStoreAndRetrive dataStoreAndRetrive;


    public List<User> getAllUsers() {
      UsersData usersData =  dataStoreAndRetrive.retriveUsersData();
        List<User> users = usersData.getUsers();
        return users;
    }
    
}
