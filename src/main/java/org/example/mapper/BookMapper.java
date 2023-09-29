package org.example.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.example.entity.Book;

import java.util.List;

@Mapper
public interface BookMapper {
    //需與 xml內的id名稱相同
    List<Book> selectAll();
}
