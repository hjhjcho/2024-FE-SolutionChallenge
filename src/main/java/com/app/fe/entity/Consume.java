package com.app.fe.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "TBL_CONSUME")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Consume {
    @Id
    @GeneratedValue
    @EqualsAndHashCode.Include
    private Long id;

    private String productName;

    private String productType;

    private int productOriginalPrice;

    private int productKoreaPrice;

    @ManyToOne
    private Nation nation;


    @Builder
    public Consume(String productName, String productType, int productOriginalPrice, int productKoreaPrice, Nation nation){
        this.productName=productName;
        this.productType=productType;
        this.productOriginalPrice=productOriginalPrice;
        this.productKoreaPrice=productKoreaPrice;
        this.nation=nation;
    }
}
