package com.makeup.repository;

import com.makeup.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;


public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findByTitleContaining(String keyword);

    @Query("select p from Post p join fetch p.member where p.postId = :postId")
    Optional<Post> findByIdWithMember(Long postId);

    @Query("select p from Post p join fetch p.member")
    List<Post> findAllWithMember();
}
