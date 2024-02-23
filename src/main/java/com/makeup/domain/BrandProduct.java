package com.makeup.domain;

import com.makeup.dto.BrandProductDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class BrandProduct extends BaseTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long brandProductId;
    private String brandName;
    private String productName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private Post post;

    public static BrandProduct toBrandProductAndAddToPost(BrandProductDto dto, Post post) {
        BrandProduct bp = BrandProduct.builder()
                .brandName(dto.getBrandName())
                .productName(dto.getProductName())
                .post(post)
                .build();

        post.getBrandProducts().add(bp);

        return bp;
    }

    public static BrandProduct toBrandProduct(BrandProductDto dto, Post post) {
        return BrandProduct.builder()
                .brandName(dto.getBrandName())
                .productName(dto.getProductName())
                .post(post)
                .build();

    }
}
