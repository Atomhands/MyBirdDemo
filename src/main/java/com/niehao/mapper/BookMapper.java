package com.niehao.mapper;

import com.niehao.model.Book;

import java.util.List;

public interface BookMapper {

    List<Book> selectList();

    //void insert(Book book);
}
