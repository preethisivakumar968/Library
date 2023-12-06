package com.library.library.entity;

import com.opencsv.bean.CsvBindByPosition;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {

    @CsvBindByPosition(position = 0)
    String name;
    @CsvBindByPosition(position = 1)
    String first_name;
    @CsvBindByPosition(position = 2)
    String member_since;
    @CsvBindByPosition(position = 3)
    String member_till;
    @CsvBindByPosition(position = 4)
    String gender;

}
