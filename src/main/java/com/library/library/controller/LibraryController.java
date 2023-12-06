package com.library.library.controller;

import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.library.library.Services.BookService;
import com.library.library.Services.UserService;
import com.library.library.entity.User;
import com.library.library.repositories.BorrowersRepository;
import com.library.library.repositories.UsersRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class LibraryController {

    @Autowired
    UsersRepository usersRepository;
    @Autowired
    UserService userService;
    @Autowired
    BookService bookService;
    @Autowired
    BorrowersRepository borrowersRepository;

    @GetMapping("/users/all")
    public List<User> getAllUsers() {
        return usersRepository.getAllUsers();

    }

    @GetMapping("/users/nonBorrowed")
    public List<User> getAllNonBorrowedUsers() {
        return userService.getAllCurrentNonBorrowedUsers();

    }

    @GetMapping("/books/nonBorrowed")
    public List<String> getAllNonBorrowedBooks() {
        return bookService.getAllCurrentNonBorrowedBooks();

    }

    @GetMapping("/users/borrowbydate")
    public Set<String> getUsersBorrowedByDate(@RequestParam(name = "startdate",required = true) Date startDate) throws Exception {
        return borrowersRepository.getUsersBorrowedByDate(startDate);
    }

    @GetMapping("/books/borrowedbyuseranddaterange")
    public Set<String> getBooksBorrowedByUserAndDateRange(@RequestParam(name = "username",required = true) String userName,
    @RequestParam(name = "startdate",required = true)  Date startDate,
    @RequestParam(name = "enddate",required = true)   Date endDate) throws Exception {
        return borrowersRepository.getBooksBorrowedByUserAndDateRange(userName, startDate, endDate);
    }

}
