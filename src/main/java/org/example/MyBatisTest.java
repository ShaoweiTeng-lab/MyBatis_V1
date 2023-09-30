package org.example;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.example.entity.Book;
import org.example.mapper.BookMapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MyBatisTest {

    public static void main(String[] args) throws IOException {
//        bookSelectAll();
        bookSelectByIsbn("9780071751292");
    }

    public static void  bookSelectAll() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);//拿到 Resource 底下的 xml
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);//透過stream 創立session factory

        //獲取sqlSession ，用來執行sql
        SqlSession sqlSession =sqlSessionFactory.openSession();

        //得到Mapper代理對象
        BookMapper mapper =sqlSession.getMapper(BookMapper.class);//傳入id 名稱
        //執行sql
        List<Book> books =mapper.selectAll();
        books.forEach(data-> System.out.println(data));
    }

    public static  void bookSelectByIsbn(String isbn) throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);//拿到 Resource 底下的 xml
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);//透過stream 創立session factory

        //獲取sqlSession ，用來執行sql
        SqlSession sqlSession =sqlSessionFactory.openSession();

        //得到Mapper代理對象
        BookMapper mapper =sqlSession.getMapper(BookMapper.class);//傳入id 名稱
        //執行sql
        Book book =mapper.selectByIsbn(isbn);
        System.out.println(book);;
    }
}
