package com.min.shop.entity.item;

import com.min.shop.entity.item.Book;
import com.min.shop.entity.member.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BookRepository extends JpaRepository<Book, Long> {
    @Query("select i from Item i where i.name=:name")
    Book findByName(@Param("name") String name);
}
