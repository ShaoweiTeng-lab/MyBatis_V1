package org.example.entity;

import lombok.Data;

@Data
public class OrderDetail {
    private  Integer orderId;
    private  String isbn;
    private  Integer quantity;
    //一對一
    private  Book book;
}
