package org.example.dto;

import lombok.Data;

import java.sql.Date;

@Data
public class BookInsertDto {
    private  String isbn;
    private  String bookName;
    private  Double price;
    private  String author;
    private  Date   publicationDate;
    private  String publisherId;

}
