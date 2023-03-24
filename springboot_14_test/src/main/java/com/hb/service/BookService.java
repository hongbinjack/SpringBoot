package com.hb.service;

import com.hb.domain.Book;
import org.apache.ibatis.annotations.Mapper;


public interface BookService {
      public boolean save(Book book);
}
