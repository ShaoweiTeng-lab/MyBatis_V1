package org.example.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.example.dto.MemberInsertDto;
import org.example.dto.MemberUpdateDto;
import org.example.entity.Member;

import java.util.List;

@Mapper
public interface MemberMapper {
    Integer insertMember(MemberInsertDto memberInsertDto);

    Integer updateMember(MemberUpdateDto memberUpdateDto);

    Integer deleteMemberById(Integer id);
    Integer deleteMemberByIds(List<Integer> ids);

    List<Member> selectMember(@Param("memberId") Integer memberId, @Param("account") String account,@Param("name")  String name);
}
