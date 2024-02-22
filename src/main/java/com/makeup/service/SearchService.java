package com.makeup.service;

import com.makeup.domain.MenteeReservation;
import com.makeup.domain.Post;
import com.makeup.dto.MenteeReservationDto;
import com.makeup.dto.SearchResultDto;
import com.makeup.repository.PostRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SearchService {
    private final PostRepository postRepository;

    @Transactional public List<SearchResultDto> search(String keyword) {
        List<Post> searchedPostList = postRepository.findByTitleContaining(keyword);

        List<SearchResultDto> searchResultDtoList = new ArrayList<>();
        for (Post post : searchedPostList){
            searchResultDtoList.add(SearchResultDto.SearchFrom(post));

        }
        return searchResultDtoList;
    }

}
