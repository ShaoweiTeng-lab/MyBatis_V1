package org.example.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class BookQuery {
    private  String isbn;
    private  String bookName;
    private  String author;
    private  String order;
    private  OrderEnum orderEnum;
}

