package com.library.library.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.library.repositories.BookRepository;
import com.library.library.repositories.BorrowersRepository;

@Service
public class BookService {

    @Autowired
    BorrowersRepository borrowersRepository;
    @Autowired
    BookRepository bookRepository;

    public List<String> getAllCurrentNonBorrowedBooks() {
        List<String> nonBorrowedBooks = new ArrayList<>();
        List<String> books = bookRepository.getAllTitles();
        List<String> borrowedBooks = borrowersRepository.getAllBorrowerBooks();
        for (String book : books) {
            if (!borrowedBooks.contains(book)) {
                nonBorrowedBooks.add(book);
            }
        }
        return nonBorrowedBooks;
    }
    
}
