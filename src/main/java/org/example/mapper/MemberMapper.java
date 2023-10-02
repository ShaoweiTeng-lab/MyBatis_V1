package org.example.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.example.dto.MemberInsertDto;
import org.example.dto.MemberUpdateDto;

import java.util.List;

@Mapper
public interface MemberMapper {
    Integer insertMember(MemberInsertDto memberInsertDto);

    Integer updateMember(MemberUpdateDto memberUpdateDto);

    Integer deleteMemberById(Integer id);
    Integer deleteMemberByIds(List<Integer> ids);
}
