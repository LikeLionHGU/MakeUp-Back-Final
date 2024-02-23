package com.makeup.domain;

import com.makeup.controller.Form.PostForm;
import com.makeup.dto.PostDto;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postId;

    private String title;

    private String imageUrl;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id") // 데이터베이스의 실제 컬럼 이름으로 수정
    private Member member;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<BrandProduct> brandProducts = new ArrayList<>();

    public static Post toPost(PostDto dto, Member member) {
        return Post.builder()
                .title(dto.getTitle())
                .imageUrl(dto.getImageUrl())
                .brandProducts(new ArrayList<>())
                .member(member)
                .build();
    }
}
