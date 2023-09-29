package org.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;


@NoArgsConstructor
@Data
public class Book {
    private String isbn;
    private String bookName;
    private Double price;
    private String author;
    private Date publicationDate;
    private String publisherId;
    @Override
    public  String toString(){
        return String.format(
                " isbn : %s  ,\n " +
                "isbn : %s  ,\n " +
                "isbn : %f  ,\n " +
                        "isbn : %s  ,\n " +
                        "isbn : %s  ,\n " +
                        "isbn : %s  \n ", isbn, bookName, price,author,publicationDate,publisherId);
    }
}
