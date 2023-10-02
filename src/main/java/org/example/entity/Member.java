package org.example.entity;

import lombok.Data;

import java.sql.Date;
@Data
public class Member {
    private Integer memberId;
    private  String account;
    private  String name;
    private  String password;
    private  String email;
    private Date createdDate;
}
