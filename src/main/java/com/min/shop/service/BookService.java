package com.min.shop.service;

import com.min.shop.entity.item.BookRepository;
import com.min.shop.entity.item.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    @Transactional
    public void saveItem(Book book) {
        bookRepository.save(book);
    }

    public Book findById(Long id) {
        return bookRepository.findById(id).get();
    }

    public Book findByName(String name) {
        return bookRepository.findByName(name);
    }

    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Transactional
    public void updateItem(Long id, String name, Integer price, Integer stockQuantity) {
        Book book = bookRepository.findById(id).get(); //조회로 인해 영속상태
        book.setName(name); //변경감지
        book.setPrice(price);
        book.setStockQuantity(stockQuantity);
    }
}
