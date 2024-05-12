package com.iweb.mapper;

import com.iweb.model.Book;

import java.util.List;

public interface BookMapper {

    List<Book> selectList();

    void insert(Book book);
}
