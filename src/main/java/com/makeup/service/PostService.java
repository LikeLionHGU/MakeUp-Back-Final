package com.makeup.service;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ListObjectsV2Request;
import com.amazonaws.services.s3.model.ListObjectsV2Result;
import com.amazonaws.services.s3.model.S3ObjectSummary;
import com.makeup.domain.Post;
import com.makeup.dto.PostCreateRequestDto;
import com.makeup.dto.PostUpdateRequestDto;
import com.makeup.exception.ResourceNotFoundException;
import com.makeup.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PostService {

    private final AmazonS3 s3Client;
    private final S3Service s3Service;
    private final PostRepository postRepository;

    @Value("${app.s3.bucket}")
    private String bucketName;

    // 이 메소드 수정
    public List<String> getFilesUrls() {
        ListObjectsV2Result result = s3Client.listObjectsV2(new ListObjectsV2Request().withBucketName(bucketName));
        List<S3ObjectSummary> objects = result.getObjectSummaries();

        return objects.stream().map(obj -> s3Client.getUrl(bucketName, obj.getKey()).toString()).collect(Collectors.toList());
    }

    public Post createPost(PostCreateRequestDto postCreateRequestDto, MultipartFile file) {
        String url = s3Service.uploadFile(file); // 파일 업로드 로직 호출
        Post post = Post.builder()
                .title(postCreateRequestDto.getTitle())
                .brandName(postCreateRequestDto.getBrandName())
                .cosName(postCreateRequestDto.getCosName())
                .imageUrl(url)
                .text(postCreateRequestDto.getText()) // 필요에 따라 처리
                // .member 처리 필요, 예를 들어, memberId를 사용하여 member 객체를 조회하고 설정
                .build();
        return postRepository.save(post); // 생성된 Post 객체를 반환
    }


    // updatePost 메소드 수정
    public Post updatePost(Long postId, PostUpdateRequestDto requestDto, MultipartFile file) {
        Post post = postRepository.findById(postId).orElseThrow(() -> new IllegalArgumentException("해당 게시물이 없습니다."));
        String url = s3Service.uploadFile(file); // 파일 업로드 로직 호출
        // update 메소드 호출 시 모든 필요한 매개변수 전달
        post.update(requestDto.getTitle(), requestDto.getContent(), url, requestDto.getText(), requestDto.getBrandName(), requestDto.getCosName());

        return postRepository.save(post); // 수정된 Post 객체를 반환
    }

    // DeltePost 메소드 추가
    public void deletePost(Long id) {
        Post post = postRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시물이 없습니다."));
        postRepository.delete(post);
    }


    public Post getPostById(Long postId) {
        return postRepository.findById(postId)
                .orElseThrow(() -> new ResourceNotFoundException("Post not found with id: " + postId));
    }
}