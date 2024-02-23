package com.makeup.dto;

import com.makeup.domain.BrandProduct;
import lombok.*;

@Getter
public class BrandProductDto {

    private String brandName;
    private String productName;

    public BrandProductDto(BrandProduct brandProduct) {
        this.brandName = brandProduct.getBrandName();
        this.productName = brandProduct.getProductName();
    }
}
