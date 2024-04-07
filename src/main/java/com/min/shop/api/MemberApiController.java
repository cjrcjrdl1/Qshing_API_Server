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
    private final GeoService geoService;

    @PostMapping("/api/address")
    public CreateAddressResponse saveAddress(@RequestBody @Valid CreateAddressRequest request) {
        Address address = new Address();
        address.setAddress(request.getAddress());
        String gpsInput = request.getGps();
        String realAddress = findRealAddress(gpsInput);

        address.setGps(realAddress);
        String name = addressService.join(address);
        String risk = addressService.isRisk(name);
        Address real = addressService.findByAddress(name);

        return new CreateAddressResponse(real.getAddress(), real.getGps(), risk);
    }

    private String findRealAddress(String gpsInput) {
        String[] gpsParts = gpsInput.split(" ");
        Double latitude = Double.valueOf(gpsParts[1]);
        Double longitude = Double.valueOf(gpsParts[3]);
        String realAddress = geoService.getAddressFromCoordinates(latitude, longitude);
        return realAddress;
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
