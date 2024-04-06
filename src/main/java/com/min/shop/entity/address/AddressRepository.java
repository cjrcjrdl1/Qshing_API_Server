package com.min.shop.entity.address;

import com.min.shop.entity.item.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AddressRepository extends JpaRepository<Address, Long> {

    @Query("select a from Address a where a.address=:name")
    Address findByName(@Param("name") String name);
}
