package com.hb.service.impl;

import com.hb.dao.BookDao;
import com.hb.domain.Book;
import com.hb.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao bookDao;



    @Override
    public boolean save(Book book) {
          return bookDao.insert(book) > 0;
    }
}
