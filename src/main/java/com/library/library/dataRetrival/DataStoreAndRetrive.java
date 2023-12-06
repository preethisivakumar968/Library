package com.library.library.dataRetrival;

import org.springframework.stereotype.Component;

import com.library.library.dataStorage.BookData;
import com.library.library.dataStorage.BorrowersData;
import com.library.library.dataStorage.UsersData;

public class DataStoreAndRetrive {

    public  static BookData booksData;
    public static BorrowersData borrowersData;
    public static UsersData usersData;

    public static void storeBookObject(BookData booksData) {
        DataStoreAndRetrive.booksData = booksData;
    }

     public static void storeBorrowerObject(BorrowersData borrowersData) {
        DataStoreAndRetrive.borrowersData = borrowersData;
    }

       public static void storeUsersObject(UsersData usersData) {
        DataStoreAndRetrive.usersData = usersData;
    }

    public static BookData retriveData() {
    
        return DataStoreAndRetrive.booksData;
    }

    public static BorrowersData retriveBorrowerData() {
    
        return DataStoreAndRetrive.borrowersData;
    }

    public static UsersData retriveUsersData() {
    
        return DataStoreAndRetrive.usersData;
    }

    
}
