package org.example;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.example.entity.Book;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Demo1 {
    public static void main(String[] args) throws IOException {
        //加載myBatis 的配置文件，獲取sessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);//拿到 Resource 底下的 xml
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);//透過stream 創立session factory

        //獲取sqlSession ，用來執行sql
        SqlSession sqlSession =sqlSessionFactory.openSession();

        //執行sql
        List<Book> bookList=sqlSession.selectList("org.example.mapper.BookMapper.selectAll");//傳入id 名稱
        System.out.println(bookList.size());
        //釋放資源
        sqlSession.close();
    }
}