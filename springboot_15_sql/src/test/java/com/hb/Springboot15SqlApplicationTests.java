package com.hb;

import com.hb.dao.BookDao;
import com.hb.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@SpringBootTest
class Springboot15SqlApplicationTests {

//    @Autowired
//    private BookDao bookDao;

    @Test
    void getById(){
//        System.out.println(bookDao.selectById(1));
    }

    @Test
    void TestJdbcTemplate(@Autowired JdbcTemplate jdbcTemplate){

        String sql = "select  * from  tbl_book";
//        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql);
//        System.out.println(maps);
        RowMapper<Book> rm = new RowMapper<Book>(){

            @Override
            public Book mapRow(ResultSet resultSet, int i) throws SQLException {
                Book book = new Book();
                book.setId(resultSet.getInt("id"));
                book.setName(resultSet.getString("name"));
                book.setType(resultSet.getString("type"));
                book.setDescription(resultSet.getString("description"));
                return book;
            }
        };
        List<Book> list = jdbcTemplate.query(sql, rm);
        System.out.println(list);
    }


    @Test
    void testJdbcTemplateSava(@Autowired JdbcTemplate jdbcTemplate){
        String sql = "insert into tbl_book(id,name,description,type) value(null,'name','description','type')";
       jdbcTemplate.update(sql);


    }
}
