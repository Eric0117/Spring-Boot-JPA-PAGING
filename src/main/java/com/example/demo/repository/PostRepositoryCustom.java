package com.example.demo.repository;

import com.example.demo.dto.PostResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @Author Eric
 * @Description
 * @Since 22. 9. 4.
 **/
public interface PostRepositoryCustom {
    Page<PostResponseDTO> getOffsetPosts(Pageable pageable);
    Page<PostResponseDTO> getCursorPosts(Pageable pageable, Long cursorIdx);
}
