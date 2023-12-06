package com.library.library;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStream;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.library.library.dataRetrival.DataStoreAndRetrive;
import com.library.library.dataStorage.BookData;
import com.library.library.dataStorage.BorrowersData;
import com.library.library.dataStorage.UsersData;
import com.library.library.entity.Books;
import com.library.library.entity.Borrower;
import com.library.library.entity.User;
import com.opencsv.bean.CsvToBeanBuilder;

import lombok.extern.java.Log;

@SpringBootApplication
@Log
public class LibraryApplication implements CommandLineRunner {

	public static void main(String[] args)  {
		SpringApplication.run(LibraryApplication.class, args);
	}

	@Override
	public void run(String... args) throws FileNotFoundException {

	    List<Books> bookList = new CsvToBeanBuilder(new FileReader("/Users/balajimurugesan/preethiproject/Library/src/main/java/com/library/library/files/books.csv")).withType(Books.class).build().parse();
	    List<Borrower> borrowerList = new CsvToBeanBuilder(new FileReader("/Users/balajimurugesan/preethiproject/Library/src/main/java/com/library/library/files/borrowed.csv")).withType(Borrower.class).build().parse();
	    List<User> userList = new CsvToBeanBuilder(new FileReader("/Users/balajimurugesan/preethiproject/Library/src/main/java/com/library/library/files/user.csv")).withType(User.class).build().parse();
	    
	    BookData bookData = new BookData(bookList);
	    BorrowersData borrowersData = new BorrowersData(borrowerList);
	    UsersData usersData = new UsersData(userList);
	    
	    DataStoreAndRetrive.storeBookObject(bookData);
	    DataStoreAndRetrive.storeBorrowerObject(borrowersData);
	    DataStoreAndRetrive.storeUsersObject(usersData);
        log.info("Application started successfully");
	
	}

}
