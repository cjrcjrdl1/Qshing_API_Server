package com.min.shop.api;

import com.min.shop.entity.address.Address;
import com.min.shop.entity.member.Member;
import com.min.shop.service.AddressService;
import com.min.shop.service.MemberService;
import jakarta.validation.Valid;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MemberApiController {

    private final AddressService addressService;

    @PostMapping("/api/address")
    public CreateAddressResponse saveAddress(@RequestBody @Valid CreateAddressRequest request) {
        Address address = new Address();
        address.setAddress(request.getAddress());
        //안전한지 아닌지 판단하는 로직 필요(백단에서 구현)
        //GPS 판단 로직 필요 (프론트에서 받아와야 할 듯)
        
        String name = addressService.join(address);
        return new CreateAddressResponse(name);
    }

    @Data
    static class CreateAddressRequest {
        private String address;
    }

    @Data
    static class CreateAddressResponse {
        private String address;

        public CreateAddressResponse(String address) {
            this.address = address;
        }
    }
}
