package com.example.demo.service.impl;

import com.example.demo.domain.Post;
import com.example.demo.dto.PostResponseDTO;
import com.example.demo.repository.PostRepository;
import com.example.demo.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * @Author Eric
 * @Description
 * @Since 22. 9. 4.
 **/
@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;


    @Override
    public Page<PostResponseDTO> getOffsetPosts(Pageable pageable) {
        return postRepository.getOffsetPosts(pageable);
    }

    @Override
    public Page<PostResponseDTO> getCursorPosts(Pageable pageable, Long cursorIdx) {
        return postRepository.getCursorPosts(pageable, cursorIdx);
    }
}
