package com.library.library.repositories;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


import org.springframework.stereotype.Repository;

import com.library.library.dataRetrival.DataStoreAndRetrive;
import com.library.library.dataStorage.BorrowersData;
import com.library.library.entity.Borrower;

@Repository
public class BorrowersRepository {

    DataStoreAndRetrive dataStoreAndRetrive;


    public Set<String> getAllBorrowers() {
      BorrowersData borrowersData  =  DataStoreAndRetrive.retriveBorrowerData();
        List<Borrower> borrowers = borrowersData.getBorrowers();
        Set<String> borrowerNames = new HashSet<>();
        for(Borrower borrower : borrowers) {
            borrowerNames.add(borrower.getBorrower());
        }
        return borrowerNames;  
    }

    public List<String> getAllBorrowerBooks() {
      BorrowersData borrowersData  =  DataStoreAndRetrive.retriveBorrowerData();
        List<Borrower> borrowers = borrowersData.getBorrowers();
        List<String> borroweBooks = new ArrayList<>();
        for(Borrower borrower : borrowers) {
            borroweBooks.add(borrower.getBook());
        }
        return borroweBooks;
    }


    public Set<String> getBooksBorrowedByUserAndDateRange(String userName, Date startDate, Date endDate) throws ParseException {
      BorrowersData borrowersData  =  DataStoreAndRetrive.retriveBorrowerData();
        List<Borrower> borrowers = borrowersData.getBorrowers();
        Set<String> borrowBooksSet = new HashSet<>();
        borrowers.sort((b1, b2) -> b1.getBorrower().compareTo(b2.getBorrower()));   
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
        for(Borrower borrower : borrowers) {
            if(borrower.getBorrower().equals(userName) && formatter.parse(borrower.getBorrowedFrom()).compareTo(startDate) >= 0 && formatter.parse(borrower.getBorrowedTo()).compareTo(endDate) <= 0) {
                borrowBooksSet.add(borrower.getBook());
            }
        }
        return borrowBooksSet;
    }

    public Set<String> getUsersBorrowedByDate(Date startDate) throws ParseException {
      BorrowersData borrowersData  =  DataStoreAndRetrive.retriveBorrowerData();
        List<Borrower> borrowers = borrowersData.getBorrowers();
        Set<String> usersSet = new HashSet<>();
        borrowers.sort((b1, b2) -> b1.getBorrower().compareTo(b2.getBorrower()));   
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
        for(Borrower borrower : borrowers) {
             if(formatter.parse(borrower.getBorrowedFrom()).compareTo(startDate) == 0) {
                usersSet.add(borrower.getBorrower());
            }
        }
        return usersSet;
    }



        


    
    
}
