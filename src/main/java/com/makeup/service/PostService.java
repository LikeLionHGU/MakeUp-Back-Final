package com.makeup.service;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ListObjectsV2Request;
import com.amazonaws.services.s3.model.ListObjectsV2Result;
import com.amazonaws.services.s3.model.S3ObjectSummary;
import com.makeup.controller.Form.PostForm;
import com.makeup.domain.BrandProduct;
import com.makeup.domain.Member;
import com.makeup.domain.Post;
import com.makeup.dto.BrandProductDto;
import com.makeup.dto.PostCreateRequestDto;
import com.makeup.dto.PostDto;
import com.makeup.dto.PostUpdateRequestDto;
import com.makeup.exception.MemberNotFoundException;
import com.makeup.exception.PostNotFoundException;
import com.makeup.exception.ResourceNotFoundException;
import com.makeup.repository.MemberRepository;
import com.makeup.repository.PostRepository;
import jakarta.transaction.Transactional;
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

    private final S3Service s3Service;

    private final PostRepository postRepository;

    private final MemberRepository memberRepository;

    public Post createPost(PostForm postForm, MultipartFile file) {
        String url = s3Service.uploadFile(file); // 파일 업로드 로직 호출

        PostDto postDto = PostDto.from(postForm, url);
        Member member =
                memberRepository
                        .findMemberById(postDto.getMemberId())
                        .orElseThrow(MemberNotFoundException::new);

        Post post = Post.toPost(postDto, member);
        List<BrandProduct> brandProducts = postDto.getBrandProducts().stream().map(bp -> BrandProduct.toBrandProductAndAddToPost(bp, post)).toList();

        return postRepository.save(post); // 생성된 Post 객체를 반환
    }


    // updatePost 메소드 수정
    @Transactional
    public void updatePost(Long postId, PostForm postForm, MultipartFile file) {
        Post post = postRepository.findById(postId).orElseThrow(() -> new IllegalArgumentException("해당 게시물이 없습니다."));
        String url = s3Service.uploadFile(file);

        PostDto postDto = PostDto.from(postForm, url);

        List<BrandProduct> brandProducts = postDto.getBrandProducts().stream().map(bp -> BrandProduct.toBrandProduct(bp, post)).toList();

        post.setTitle(postForm.getTitle());
        post.setImageUrl(url);
        post.setBrandProducts(brandProducts);

    }

    @Transactional
    public void updatePost(Long postId, PostForm postForm) {
        Post post = postRepository.findById(postId).orElseThrow(() -> new IllegalArgumentException("해당 게시물이 없습니다."));

        post.setTitle(postForm.getTitle());
        PostDto postDto = PostDto.from(postForm);

        List<BrandProduct> brandProducts = postDto.getBrandProducts().stream().map(bp -> BrandProduct.toBrandProduct(bp, post)).toList();

        post.setTitle(postForm.getTitle());
        post.setBrandProducts(brandProducts);
    }

    // DeltePost 메소드 추가
    public void deletePost(Long id) {
        Post post = postRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시물이 없습니다."));
        postRepository.delete(post);
    }

    public PostDto getPostById(Long postId) {
        Post post = postRepository.findById(postId).orElseThrow(PostNotFoundException::new);
        return PostDto.from(post);
    }

    public List<PostDto> getAllPosts() {
        List<Post> posts = postRepository.findAll();
        return posts.stream().map(PostDto::from).toList();
    }

    public List<PostDto> search(String keyword) {
        List<Post> searchedPosts = postRepository.findByTitleContaining(keyword);
        return searchedPosts.stream().map(PostDto::from).toList();
    }
}