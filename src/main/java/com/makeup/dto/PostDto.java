package com.makeup.dto;

import com.makeup.controller.Form.PostForm;
import com.makeup.domain.Post;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostDto {

    private Long postId;

    private String title;

    private String imageUrl;

    private Long memberId;

    private List<BrandProductDto> brandProducts;

    public static PostDto from(Post post) {
        List<BrandProductDto> brandProducts = post.getBrandProducts().stream()
                .map(BrandProductDto::new)
                .toList();

        return PostDto.builder()
                .postId(post.getPostId())
                .title(post.getTitle())
                .imageUrl(post.getImageUrl())
                .brandProducts(brandProducts)
                .build();
    }

    public static PostDto from(PostForm form, String imageUrl) {
        return PostDto.builder()
                .title(form.getTitle())
                .imageUrl(imageUrl)
                .memberId(form.getMemberId())
                .brandProducts(form.getBrandProducts())
                .build();
    }

    public static PostDto from(PostForm form) {
        return PostDto.builder()
                .title(form.getTitle())
                .memberId(form.getMemberId())
                .brandProducts(form.getBrandProducts())
                .build();
    }
}
