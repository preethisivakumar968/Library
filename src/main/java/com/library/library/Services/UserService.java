package com.library.library.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.library.entity.User;
import com.library.library.repositories.BorrowersRepository;
import com.library.library.repositories.UsersRepository;

import lombok.extern.java.Log;

@Service
@Log
public class UserService {

  @Autowired
  UsersRepository usersRepository;
  @Autowired
  BorrowersRepository borrowersRepository;

  public List<User> getAllCurrentNonBorrowedUsers() {
    List<User> users = usersRepository.getAllUsers();
    Set<String> borrowers = borrowersRepository.getAllBorrowers();
    borrowers.forEach(borrower -> {
      users.removeIf(user -> {
        StringBuilder stringBuilder = new StringBuilder(user.getName());
        stringBuilder.append(",");
        stringBuilder.append(user.getFirst_name());
        return stringBuilder.toString().equals(borrower);
      });
    });

    return users;
  }

}
