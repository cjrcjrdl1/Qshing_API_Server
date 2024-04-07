package com.min.shop.service;

import com.min.shop.entity.address.Address;
import com.min.shop.entity.address.AddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    public Address findByAddress(String address) {
        return addressRepository.findByName(address);
    }

    @Transactional
    public String isRisk(String address) {
        Address real = findByAddress(address);
        String status = "NO";
        if (isWarning(real)) {
            real.setRisk("YES");
            status = "Warning site";
        }

        if (address.matches(isIP())) {
            real.setRisk("YES");
            status = "Warning site";
        }

        if (status.equals("NO")) {
            real.setRisk("NO");
            return "Safe site";
        }

        return status;
    }

//    public String findGps(String gps) {
//
//    }

    private static String isIP() {
        return "^(https?://)?([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
                "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
                "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
                "([01]?\\d\\d?|2[0-4]\\d|25[0-5])$";
    }

    private static boolean isWarning(Address real) {
        return !real.getAddress().toLowerCase().startsWith("https://");
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
