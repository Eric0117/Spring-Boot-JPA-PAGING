package com.example.demo.repository;

import com.example.demo.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author Eric
 * @Description
 * @Since 22. 9. 4.
 **/
public interface PostRepository extends JpaRepository<Post, Long>, PostRepositoryCustom {
}
