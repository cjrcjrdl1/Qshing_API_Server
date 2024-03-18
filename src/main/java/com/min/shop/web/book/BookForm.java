package com.min.shop.web.book;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookForm {

    private Long id;
    private String name;
    private String description;
    private Integer price;
    private Integer stockQuantity;
    private String author;
    private String isbn;
}
