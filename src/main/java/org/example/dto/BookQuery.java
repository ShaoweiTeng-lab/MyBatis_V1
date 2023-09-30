package org.example.dto;

import lombok.Data;

@Data
public class BookQuery {
    private  String isbn;
    private  String bookName;
    private  String author;
}
