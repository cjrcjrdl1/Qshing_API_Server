package com.min.shop.service;

import com.min.shop.entity.*;
import com.min.shop.entity.item.Book;
import com.min.shop.entity.item.Item;
import com.min.shop.entity.member.Member;
import com.min.shop.entity.order.Order;
import com.min.shop.entity.order.OrderRepository;
import com.min.shop.entity.order.OrderStatus;
import com.min.shop.exception.NotEnoughStockException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@Transactional
class OrderServiceTest {

    @PersistenceContext
    EntityManager em;

    @Autowired
    OrderService orderService;
    @Autowired
    OrderRepository orderRepository;

    @Test
    void order() {
        //given
        Member member = createMember();
        Item item = createBook("클린코드", 10000, 10);
        int orderCount = 2;

        //when
//        Long orderId = orderService.order(member.get(), item.getId(), orderCount);
//
//        //then
//        Order getOrder = orderRepository.findById(orderId).get();
//
//        assertEquals(OrderStatus.ORDER, getOrder.getStatus()); //상품 주문시 상태는 ORDER
//        assertEquals(1, getOrder.getOrderItems().size()); //주문 상품 종류수
//        assertEquals(10000 * 2, getOrder.getTotalPrice()); //주문 가격은 가격*수량
//        assertEquals(8, item.getStockQuantity()); //주문 수량만큼 재고가 줄어야 함
    }

    @Test
    void stockQuantity_over() {
        //given
        Member member = createMember();
        Item item = createBook("리팩터링", 10000, 10);

        int orderCount = 11;

        //when
//        orderService.order(member.getId(), item.getId(), orderCount);

        //then
//        assertThrows(NotEnoughStockException.class,
//                () -> orderService.order(member.getId(), item.getId(), orderCount)); //재고수량 부족으로 예외
    }

    @Test
    void cancelOrder() {
        //given
        Member member = createMember();
        Item item = createBook("리버싱", 10000, 10);
        int orderCount = 2;

//        Long orderId = orderService.order(member.getId(), item.getId(), orderCount);
//
//        //when
//        orderService.cancelOrder(orderId);
//
//        //then
//        Order getOrder = orderRepository.findById(orderId).get();
//        assertEquals(OrderStatus.CANCEL, getOrder.getStatus());
//        assertEquals(10, item.getStockQuantity());
    }

    private Member createMember() {
        Member member = new Member();
        member.setName("회원1");
        member.setAddress(new Address("서울", "서초", "123-123"));
        em.persist(member);
        return member;
    }

    private Book createBook(String name, int price, int stockQuantity) {
        Book book = new Book();
        book.setName(name);
        book.setPrice(price);
        book.setStockQuantity(stockQuantity);
        em.persist(book);
        return book;
    }
}