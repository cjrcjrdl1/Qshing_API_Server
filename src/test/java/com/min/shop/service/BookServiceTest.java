package com.min.shop.service;

import com.min.shop.entity.item.BookRepository;
import com.min.shop.entity.item.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Transactional
class BookServiceTest {

    @Autowired
    BookService bookService;
    @Autowired
    BookRepository bookRepository;

    @Test
    public void saveItem() {
        //given
        Book item = new Book();
        item.setName("정처기");

        //when
        bookService.saveItem(item);

        //then
        assertEquals(item, bookRepository.findById(item.getId()));

    }

}