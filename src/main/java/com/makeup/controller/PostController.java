package com.makeup.controller;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ListObjectsV2Request;
import com.amazonaws.services.s3.model.ListObjectsV2Result;
import com.amazonaws.services.s3.model.S3ObjectSummary;
import com.fasterxml.jackson.databind.ser.Serializers;
import com.makeup.controller.Form.AvailableDateForm;
import com.makeup.controller.Form.PostForm;
import com.makeup.controller.Response.ApiResponse;
import com.makeup.controller.Response.MentoDateIdResponse;
import com.makeup.domain.Post;
import com.makeup.dto.*;
import com.makeup.response.BaseResponse;
import com.makeup.response.PostResponse;
import com.makeup.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@RestController()
@RequestMapping("/posts")
public class PostController {
    private final PostService postService;
    private final CalendarService calendarService;

    // 게시물 생성
    @PostMapping
    public BaseResponse<?> createPost(@RequestPart("json") PostForm postForm,
                                      @RequestPart("file") MultipartFile file) {
        postService.createPost(postForm, file); // 수정된 서비스 메서드 호출
        return BaseResponse.ok();
    }

    // 게시물 삭제로직
    @DeleteMapping("/{postId}")
    public BaseResponse<?> deletePost(@PathVariable Long postId) {
        try {
            postService.deletePost(postId);
            return BaseResponse.ok();
        } catch (Exception e) {
            return BaseResponse.error(e.getMessage());
        }
    }

    // 게시물 업데이트 로직
    @PutMapping("/{postId}")
    public BaseResponse<?> updatePost(@PathVariable Long postId,
                                        @RequestPart("json") PostForm postForm,
                                        @RequestPart(value = "file", required = false) MultipartFile file) {
        try {
            if (file != null) {
                postService.updatePost(postId, postForm, file);
            }
            else {
                postService.updatePost(postId, postForm);
            }
            return BaseResponse.ok();

        } catch (Exception e) {
            return BaseResponse.error("게시물 생성 중 오류 발생");
        }
    }

    // 메인페이지
    @GetMapping
    public BaseResponse<List<PostResponse.BasicInfo>> getAllPosts() {
        List<PostDto> postDTOs = postService.getAllPosts();
        List<PostResponse.BasicInfo> body = postDTOs.stream().map(PostResponse.BasicInfo::new).toList();
        return BaseResponse.success(body);
    }

    // 게시물 상세 조회
    @GetMapping("/{postId}")
    public BaseResponse<PostResponse.Detail> getPost(@PathVariable Long postId) {
            PostDto postDto = postService.getPostById(postId);
            List<AvailableDateDto> dateDTOs = calendarService.getAvailableDatesOf(postDto.getMemberId());
            PostResponse.Detail res = new PostResponse.Detail(postDto, dateDTOs);
            return BaseResponse.success(res);
    }

    @GetMapping("/search")
    public BaseResponse<List<PostResponse.BasicInfo>> search(@RequestParam String keyword) {
        List<PostDto> searchedList = postService.search(keyword);
        List<PostResponse.BasicInfo> res = searchedList.stream().map(PostResponse.BasicInfo::new).toList();
        return BaseResponse.success(res);
    }

    @PostMapping("/calendar/{memberId}")
    public BaseResponse<Void> mentoReservation(@PathVariable Long memberId, @RequestBody AvailableDateForm availableDateForm) {
        calendarService.addReservationDate(memberId, availableDateForm);
        return BaseResponse.ok();
    }
}

