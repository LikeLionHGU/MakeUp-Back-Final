package com.makeup.dto;

import com.makeup.domain.Member;
import com.makeup.domain.MentoReservation;
import com.makeup.domain.Post;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SearchResultDto {
    private Long postId;
    private Long memberId;

    private String title;
    private String content;
    private String imageUrl;
    private String text;
    private String nickName;

    private Member member;

    public static SearchResultDto SearchFrom(Post post) {

        Member member = post.getMember();

        return SearchResultDto.builder()
                .postId(post.getPostId())
                .memberId(member.getMemberId())
                .title(post.getTitle())
                .content(post.getContent())
                .nickName(member.getUserNickname())
                .imageUrl(post.getImageUrl())
                .build();
    }
}