package com.library.library.Services;

import java.text.ParseException;
import java.util.Date;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.library.repositories.BorrowersRepository;

@Service
public class BorrowerService {

    @Autowired
    BorrowersRepository borrowersRepository;

    public Set<String> getBooksBorrowedByUserAndDateRange(String userName, Date startDate, Date endDate) throws ParseException{

        return borrowersRepository.getBooksBorrowedByUserAndDateRange(userName, startDate, endDate);

    }

    public Set<String> getBooksBorrowedByDate(Date startDate) throws ParseException{

        return borrowersRepository.getUsersBorrowedByDate(startDate);

    }

  

}
