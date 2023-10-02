package org.example;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.example.dto.BookInsertDto;
import org.example.dto.BookQuery;
import org.example.dto.OrderEnum;
import org.example.entity.Book;
import org.example.mapper.BookMapper;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.util.List;

public class MyBatisTest {

    public static void main(String[] args) throws IOException, ParseException {
//        bookSelectAll();
//        bookSelectByIsbn("9780071751292");
//        selectPublisherByBook("R Cookbook");

        //複合式查詢
//        BookQuery bookQuery =new BookQuery();
//        bookQuery.setBookName("%B%");
//        bookQuery.setOrder("book_name");
//        bookQuery.setOrderEnum(OrderEnum.ASC);
//        selectBookQuery(bookQuery);
        //新增
        BookInsertDto bookInsertDto =new BookInsertDto();
        bookInsertDto.setIsbn("9781119017930");
        bookInsertDto.setBookName("挖拎八八啦");
        bookInsertDto.setPrice(1033.5);
        bookInsertDto.setAuthor("挖嘿嘿");
        bookInsertDto.setPublicationDate(Utils.sqlDateFormat("2020-9-7") );
        bookInsertDto.setPublisherId("P001");
        insertBook(bookInsertDto);
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


    public  static  void  selectPublisherByBook(String bookName) throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);//拿到 Resource 底下的 xml
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);//透過stream 創立session factory

        //獲取sqlSession ，用來執行sql
        SqlSession sqlSession =sqlSessionFactory.openSession();

        //得到Mapper代理對象
        BookMapper mapper =sqlSession.getMapper(BookMapper.class);//傳入id 名稱
        //執行sql
        String publisher =mapper.selectPublisherByBook(bookName);
        System.out.println(publisher);;
    }

    public  static  void  selectBookQuery(BookQuery bookQuery) throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);//拿到 Resource 底下的 xml
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);//透過stream 創立session factory

        //獲取sqlSession ，用來執行sql
        SqlSession sqlSession =sqlSessionFactory.openSession();

        //得到Mapper代理對象
        BookMapper mapper =sqlSession.getMapper(BookMapper.class);//傳入id 名稱
        //執行sql
        List<Book> books =mapper.selectBook(bookQuery);
        books.forEach(book-> System.out.println(books));
    }

    public  static  void  insertBook(BookInsertDto bookInsertDto)throws  IOException{
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);//拿到 Resource 底下的 xml
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);//透過stream 創立session factory

        //獲取sqlSession ，用來執行sql
        SqlSession sqlSession =sqlSessionFactory.openSession(true);//開true的話自動提交(預設是false)

        //得到Mapper代理對象
        BookMapper mapper =sqlSession.getMapper(BookMapper.class);//傳入id 名稱

        int rs =mapper.insertBook(bookInsertDto);
        System.out.println("Result : "+rs);

        sqlSession.commit();//mybatis 預設 關閉 autocommit ， 因此執行後須自己commit
        sqlSession.close();
    }
}
