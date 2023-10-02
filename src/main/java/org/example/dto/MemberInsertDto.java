package org.example.dto;

import lombok.Data;

@Data
public class MemberInsertDto {
    public Integer memberId;
    private  String account;
    private  String name;
    private  String password;
    private  String email;
}
