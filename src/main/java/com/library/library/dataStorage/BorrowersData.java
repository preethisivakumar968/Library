package com.library.library.dataStorage;

import java.util.List;

import com.library.library.entity.Borrower;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class BorrowersData {
    
    List<Borrower> borrowers;

}
