package com.app.fe.DTO;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ConsumeDTO {
    private Long id;
    private String productName;
    private String productType;
    private int productOriginalPrice;
    private int productKoreaPrice;
    private String nationName;

    public ConsumeDTO(Long id, String productName, String productType, int productOriginalPrice, int productKoreaPrice, String nationName) {
        this.id = id;
        this.productName = productName;
        this.productType = productType;
        this.productOriginalPrice = productOriginalPrice;
        this.productKoreaPrice = productKoreaPrice;
        this.nationName = nationName;
    }
}