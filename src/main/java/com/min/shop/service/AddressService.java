package com.min.shop.service;

import com.min.shop.entity.address.Address;
import com.min.shop.entity.address.AddressRepository;
import com.min.shop.entity.member.Member;
import com.min.shop.entity.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class AddressService {

    private final AddressRepository addressRepository;

    //회원가입
    @Transactional
    public String join(Address address) {
        addressRepository.save(address);
        return address.getAddress();
    }
//    //전체 회원 조회
//    public List<Member> findMembers() {
//        return memberRepository.findAll();
//    }
//
//
//    public Optional<Member> findByLoginId(String loginId) {
////        Member member = memberRepository.findByLoginId(loginId)
////                .orElseThrow(() -> new IllegalArgumentException("해당 맴버가 없습니다. id=" + loginId));
////        return Optional.of(member);
//        return memberRepository.findByLoginId(loginId);
//    }
}
