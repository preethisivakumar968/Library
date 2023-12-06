package com.library.library;

import java.util.Date;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.util.Assert;

import com.library.library.Services.UserService;
import com.library.library.entity.User;
import com.library.library.repositories.BookRepository;
import com.library.library.repositories.BorrowersRepository;
import com.library.library.repositories.UsersRepository;

@SpringBootTest
class LibraryApplicationTests {

	@MockBean
    public UsersRepository userRepository;

    @MockBean
    private UserService userService;

	@Test
	void contextLoads() {
	}

	// test case for BookRepository class
	@Test
	void testBookRepository() {
		BookRepository bookRepository = new BookRepository();
		List<String> titles =  bookRepository.getAllTitles();
		Assert.notNull(titles, "titles should not be null");
	}

	//test case for UserService class
	@Test
	void testUserService() {
		
		List<User> users = userService.getAllCurrentNonBorrowedUsers();
		Assert.isTrue(users.size() == 0, "users should be empty");
	}

	//test case for UsersRepository class

	@Test
	void testUsersRepository() {
		UsersRepository usersRepository = new UsersRepository();
		List<User> users = usersRepository.getAllUsers();
		Assert.notNull(users, "users should not be null");
	}

	// test borrowers repository class
	@Test
	void testBorrowersRepository() {
		BorrowersRepository borrowersRepository = new BorrowersRepository();
		Set<String> borrowers = borrowersRepository.getAllBorrowers();
		Assert.notNull(borrowers, "borrowers should not be null");
	}

	// test borrowers repository class for getBooksBorrowedByUserAndDateRange method
	@Test
	void testBorrowersRepositoryGetBooksBorrowedByUserAndDateRange() throws Exception {
		BorrowersRepository borrowersRepository = new BorrowersRepository();
		Set<String> books = borrowersRepository.getBooksBorrowedByUserAndDateRange("Zhungwang,Ava", new Date("01/19/2021"), new Date("06/23/2021"));
		Assert.notNull(books, "books should not be null");
	}

	// test borrowers repository class for getUsersBorrowedByDate method
	@Test
	void testBorrowersRepositoryGetUsersBorrowedByDate() throws Exception {
		BorrowersRepository borrowersRepository = new BorrowersRepository();
		Set<String> users = borrowersRepository.getUsersBorrowedByDate(new Date("05/14/2008"));
		Assert.notNull(users, "users should not be null");
	}
	






}
