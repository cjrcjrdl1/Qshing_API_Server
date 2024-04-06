package com.min.shop.api;

import com.min.shop.entity.address.Address;
import com.min.shop.service.AddressService;
import jakarta.validation.Valid;
import lombok.Data;
import lombok.RequiredArgsConstructor;
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
        address.setGps(request.getGps());
        //안전한지 아닌지 판단하는 로직 필요(백단에서 구현)
        //GPS 판단 로직 필요 (프론트에서 받아와야 할 듯)

        String name = addressService.join(address);
        String risk = addressService.isRisk(name);
        Address real = addressService.findByAddress(name);

        return new CreateAddressResponse(real.getAddress(), real.getGps(), risk);
    }

    @Data
    static class CreateAddressRequest {
        private String address;
        // GPS
        private String gps;
    }

    @Data
    static class CreateAddressResponse {
        private String address;
        // GPS
        private String gps;
        private String risk;

        public CreateAddressResponse(String address, String gps, String risk) {
            this.address = address;
            this.gps = gps;
            this.risk = risk;
        }
    }
}
