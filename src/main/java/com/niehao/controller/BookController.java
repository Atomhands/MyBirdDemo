package com.niehao.controller;

import com.niehao.dto.DataGrid;
import com.niehao.http.HttpResult;
import com.niehao.model.Book;
import com.niehao.service.BookService;
import com.niehao.test.UserAction;
import com.niehao.utils.IdGenerate;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController // RestController + ResponseBody
@RequestMapping("book")
public class BookController {

    @Resource
    private BookService bookService;

    @Resource
    private RedisTemplate redisTemplate;

    @Resource
    private UserAction userAction;

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public HttpResult<List<Book>> finList() {
        List<Book> data = bookService.findList();
        return HttpResult.SUCCESS(data, "查询成功");
    }

    @RequestMapping(value = "save", method = RequestMethod.POST)
    public HttpResult<Book> saveBook(Book book) {
        book.setBookId(IdGenerate.uuid());
        bookService.saveBook(book);
        return HttpResult.SUCCESS(book, "新增书籍");
    }

    @Cacheable(key = "#root.method.name+\":\"+#current+\":\"+#size", cacheNames = "book")
    @RequestMapping(value = "page", method = RequestMethod.GET)
    public HttpResult<DataGrid<List<Book>>> pageList(int current, int size) {
        System.out.println("查询数据库");
        DataGrid<List<Book>> data = bookService.pageList(current, size);
        return HttpResult.SUCCESS(data, "分页查询");
    }

    @RequestMapping("name")
    public HttpResult<String> saveName(String name) {
        redisTemplate.opsForValue().set("name", name);
        userAction.show();
        return HttpResult.SUCCESS("", "测试redis");
    }

    @RequestMapping(value = "/setCookie", method = RequestMethod.GET)
    public HttpResult<String> setCooke(HttpServletResponse response) {
        Cookie cookie = new Cookie("ROLE_NAME", "ADMIN");
        response.addCookie(cookie); // 页面 替代了  session
        return HttpResult.SUCCESS("", "设置cookie");
    }
}
