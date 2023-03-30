package com.hb.service.impl;

import com.hb.dao.BookDao;
import com.hb.domain.Book;
import com.hb.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;


@Service
public class BookServiceImpl implements BookService {

    @Autowired()
    private BookDao bookDao;


       @Override
       @Cacheable(value = "cacheSpace" , key = "{#id}")
       public Book getById(Integer id){
           return bookDao.selectById(id);
       }





   /*

   private HashMap<Integer,Book> cache = new HashMap<Integer,Book>();

   @Override
    public Book getById(Integer id) {
        //通过if条件判断，如果当前缓存中没有本次要查询的数据，则进行查询，否则直接从缓存中获取数据返回
        Book book = cache.get(id);
        if(book == null) {
            Book queryBook = bookDao.selectById(id);
            cache.put(id,queryBook);
            return queryBook;
        }
        return cache.get(id);
    }
    */

    @Override
    public boolean save(Book book) {
        return bookDao.insert(book) > 0;
    }



    @Override
    public boolean update(Book book) {
        return bookDao.updateById(book) > 0;
    }

    @Override
    public boolean delete(Integer id) {
        return bookDao.deleteById(id) > 0;
    }

    @Override
    public List<Book> getAll() {
        return bookDao.selectList(null);
    }
}
