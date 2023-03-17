package com.hb.dao.impl;

import com.hb.dao.BookDao;
import org.springframework.stereotype.Repository;

@Repository
public class BookDaoImpl implements BookDao {
    @Override
    public void save() {
        System.out.println("SpringBoot is running...");
    }
}
