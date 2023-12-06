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

		String bookListFilePath = System.getProperty("user.dir") + "/src/main/resources/files/books.csv";
		String borrowerListFilePath = System.getProperty("user.dir") + "/src/main/resources/files/borrowed.csv";
		String userListFilePath = System.getProperty("user.dir") + "/src/main/resources/files/user.csv";

	    List<Books> bookList = new CsvToBeanBuilder(new FileReader(bookListFilePath)).withType(Books.class).build().parse();
	    List<Borrower> borrowerList = new CsvToBeanBuilder(new FileReader(borrowerListFilePath)).withType(Borrower.class).build().parse();
	    List<User> userList = new CsvToBeanBuilder(new FileReader(userListFilePath)).withType(User.class).build().parse();
	    
	    BookData bookData = new BookData(bookList);
	    BorrowersData borrowersData = new BorrowersData(borrowerList);
	    UsersData usersData = new UsersData(userList);
	    
	    DataStoreAndRetrive.storeBookObject(bookData);
	    DataStoreAndRetrive.storeBorrowerObject(borrowersData);
	    DataStoreAndRetrive.storeUsersObject(usersData);
        log.info("Application started successfully");
	
	}

}
