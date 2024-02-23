package com.makeup.response;

import com.makeup.dto.AvailableDateDto;
import com.makeup.dto.BrandProductDto;
import com.makeup.dto.PostDto;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.util.List;

public class PostResponse {

    @Getter
    public static class BasicInfo {
        private final Long postId;
        private final String imageUrl;
        private final String title;

        public BasicInfo(PostDto dto) {
            this.postId = dto.getPostId();
            this.imageUrl = dto.getImageUrl();
            this.title = dto.getTitle();
        }
    }

    @Getter
    public static class Detail {
        private final String title;
        private final String imageUrl;
        private final List<BrandProductDto> brandProducts;
        private final List<LocalDate> availableDates;

        public Detail(PostDto postDto, List<AvailableDateDto> dateDto) {
            this.title = postDto.getTitle();
            this.imageUrl = postDto.getImageUrl();
            this.brandProducts = postDto.getBrandProducts();
            this.availableDates = dateDto.stream().map(AvailableDateDto::getAvailableDates).toList();
        }
    }
}
