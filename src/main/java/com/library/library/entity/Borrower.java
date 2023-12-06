package com.library.library.entity;

import java.util.Date;

import com.opencsv.bean.CsvBindAndSplitByPosition;
import com.opencsv.bean.CsvBindByPosition;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Borrower {

    @CsvBindByPosition(position = 0)
    String borrower;
    @CsvBindByPosition(position = 1)
    String book;
    @CsvBindByPosition(position = 2)
    String borrowedFrom;
     @CsvBindByPosition(position = 3)
    String borrowedTo;
}
