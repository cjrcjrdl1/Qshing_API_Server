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
