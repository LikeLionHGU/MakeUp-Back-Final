package com.makeup.controller;

import com.makeup.controller.Response.ApiResponse;
import com.makeup.controller.Response.MemberResponse;
import com.makeup.domain.Post;
import com.makeup.dto.SearchResultDto;
import com.makeup.service.SearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController()
@RequestMapping("/posts")
@CrossOrigin(origins = "http://localhost:3000")
public class SearchController {

    private final SearchService searchService;
    @GetMapping("/search")
    public List<SearchResultDto> search(@RequestParam String keyword) {
        List<SearchResultDto> searchedList = searchService.search(keyword);
        return searchedList;
    }
}
