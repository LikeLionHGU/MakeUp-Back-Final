package com.makeup.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postId;

    private String title;
    private String content;
    private String imageUrl;
    private String text;
    private String brandName;
    private String cosName;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "memberId") // 데이터베이스의 실제 컬럼 이름으로 수정
    private Member member;

    public void update(String title, String content, String imageUrl, String text, String brandName, String cosName) {
        this.title = title;
        this.content = content;
        this.imageUrl = imageUrl;
        this.text = text;
        this.brandName = brandName;
        this.cosName = cosName;
    }
}
