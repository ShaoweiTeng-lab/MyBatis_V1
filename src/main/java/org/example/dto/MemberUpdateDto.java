package org.example.dto;

import lombok.Data;

@Data
public class MemberUpdateDto {
    public Integer memberId;
    private  String account;
    private  String name;
    private  String password;
    private  String email;
}
