package com.library.library.repositories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.library.library.dataRetrival.DataStoreAndRetrive;
import com.library.library.dataStorage.BookData;
import com.library.library.entity.Books;

@Repository
public class BookRepository {

     DataStoreAndRetrive dataStoreAndRetrive;
     public List<String> getAllTitles() {
       BookData bookData  =  DataStoreAndRetrive.retriveData();
         List<Books> books = bookData.getBooks();
         List<String> bookTitles = new ArrayList<>();
         for(Books book : books) {
             bookTitles.add(book.getTitle());
         }
         return bookTitles;  
     }
    
}
