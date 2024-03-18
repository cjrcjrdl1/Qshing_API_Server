package com.min.shop.web.order;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class OrderRequestDto {

    @NotEmpty(message = "주문회원을 지정해주세요")
    private String memberName;

    @NotEmpty(message = "상품명을 지정해주세요")
    private String itemName;
    
    @Min(0)
    private Integer count;

}
