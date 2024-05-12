package com.iweb.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.iweb.dto.DataGrid;
import com.iweb.error.BookException;
import com.iweb.mapper.BookMapper;
import com.iweb.model.Book;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BookService {

    @Resource
    private BookMapper bookMapper;

    public List<Book> findList() {
        return bookMapper.selectList();
    }

    @Transactional(rollbackFor = RuntimeException.class)
    public void saveBook(Book book) {
        bookMapper.insert(book);
        // throw new BookException("新增book失败");
    }

    public DataGrid<List<Book>> pageList(int current, int size) {
        PageHelper.startPage(current, size);
        List<Book> books = bookMapper.selectList();
        PageInfo<Book> info = new PageInfo<>(books);
        DataGrid<List<Book>> dataGrid = new DataGrid<>();
        dataGrid.setData(info.getList());
        dataGrid.setTotal(info.getTotal());
        return dataGrid;
    }
}
