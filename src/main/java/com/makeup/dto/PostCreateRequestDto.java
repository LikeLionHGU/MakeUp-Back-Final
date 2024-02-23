package com.makeup.dto;

import java.util.List;

public class PostCreateRequestDto {
    private String title;
    private String brandName; // 브랜드 이름 필드
    private String cosName;   // 제품 이름 필드
    private String text;      // 게시글 텍스트 필드
    private List<BrandProductPair> brandProductPairs; // 브랜드와 제품 쌍 리스트

    // 기본 생성자
    public PostCreateRequestDto() {}

    // Getters and Setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getCosName() {
        return cosName;
    }

    public void setCosName(String cosName) {
        this.cosName = cosName;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<BrandProductPair> getBrandProductPairs() {
        return brandProductPairs;
    }

    public void setBrandProductPairs(List<BrandProductPair> brandProductPairs) {
        this.brandProductPairs = brandProductPairs;
    }

    // BrandProductPair 내부 클래스
    public static class BrandProductPair {
        private String brandName; // 브랜드 이름
        private String cosName;   // 제품 이름

        // 기본 생성자
        public BrandProductPair() {}

        // Getters and Setters
        public String getBrandName() {
            return brandName;
        }

        public void setBrandName(String brandName) {
            this.brandName = brandName;
        }

        public String getCosName() {
            return cosName;
        }

        public void setCosName(String cosName) {
            this.cosName = cosName;
        }
    }
}