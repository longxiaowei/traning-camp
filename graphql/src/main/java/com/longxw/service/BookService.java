package com.longxw.service;

import com.longxw.graphql.annotation.GraphqlQuery;
import com.longxw.graphql.api.DataFetcherService;
import com.longxw.model.Book;
import org.springframework.stereotype.Service;

/**
 * @author longxw
 * @since 2020/4/7
 */
@Service
public class BookService implements DataFetcherService {

    @GraphqlQuery
    public Book bookById(String id, String name){
        Book book = new Book();
        book.setId(id);
        book.setName(name);
        return book;
    }
}
