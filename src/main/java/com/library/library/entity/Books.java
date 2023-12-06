package com.library.library.entity;

import com.opencsv.bean.CsvBindByPosition;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Books {

    @CsvBindByPosition(position = 0)
    String title;
    @CsvBindByPosition(position = 1)
    String author;
    @CsvBindByPosition(position = 2)
    String genere;
    @CsvBindByPosition(position = 3)
    String publisher;

}
