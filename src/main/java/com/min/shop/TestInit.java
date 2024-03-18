package com.min.shop;

import com.min.shop.entity.Address;
import com.min.shop.entity.member.Member;
import com.min.shop.entity.item.Book;
import com.min.shop.service.BookService;
import com.min.shop.service.MemberService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TestInit {

    private final MemberService memberService;
    private final BookService bookService;

    @PostConstruct
    public void init() {
        Member member = new Member();
        member.setLoginId("t");
        member.setName("테스트계정");
        member.setPassword("t");
        member.setAddress(new Address("시티", "거리", "집코드"));

        memberService.join(member);

        Book 리팩터링 = getBook("리팩터링", 100,30000, "1541", "마틴 파울러", "지난 20년간 전 세계 프로그래머에게 리팩터링의 교본이었던 리팩토링은, 기존 코드의 디자인을 개선하고 소프트웨어 유지 관리 능력을 향상시켰으며 기존 코드를 이해하기 쉽게 만드는 데 도움을 주었다. 간절히 기다려온 개정판 『리팩터링 2판』에는 프로그래밍 환경의 중요한 변화가 대거 반영되었다. 새로운 리팩터링 카탈로그를 자바스크립트 코드로 제시하며, 리팩터링 원칙부터 클래스 없이 리팩터링하는 방법과 데이터 조직화, 조건부 로직 간소화 방법을 다룬다. 또한 언어에 상관없이 리팩터링을 성공적으로 수행하는 실질적인 방법을 알려준다.");
        Book 순서파괴 = getBook("순서파괴", 50, 15000, "1234", "콜린 브라이어", "‘순서 파괴(Working Backwards)’란 개발자의 판단에 따라 순서대로 계획을 세워 제품을 만드는 대신, 고객의 시선에 따라 고객이 누릴 효용을 먼저 설계한 다음 그에 적합한 제품을 만든다는 뜻이다. 지금껏 아마존의 찬란한 영광을 직접 만들어온 두 저자는 이 같은 ‘아마존식 역방향 작업 혁명’이 어떻게 시장을 장악하고 고객의 기쁨을 극대화하는지 수많은 성공 사례를 들어 설명한다.\n" +
                "‘일을 시작할 땐 그 끝을 생생하게 상상하라!’ 아마존을 세계 최고의 기업으로 만든 이 한 가지 원칙을 익히면 당신은 물론 당신의 조직 역시 실패 없는 혁신과 성장을 거듭할 수 있을 것이다.");
        bookService.saveItem(리팩터링);
        bookService.saveItem(순서파괴);
    }

    private Book getBook(String name, int stockQuantity, int price, String isbn, String author, String description) {
        Book book = new Book();
        book.setName(name);
        book.setStockQuantity(stockQuantity);
        book.setPrice(price);
        book.setIsbn(isbn);
        book.setAuthor(author);
        book.setDescription(description);
        return book;
    }
}
