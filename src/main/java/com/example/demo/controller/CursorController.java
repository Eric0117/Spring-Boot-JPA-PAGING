package com.example.demo.controller;

import com.example.demo.dto.CursorPageRequestDTO;
import com.example.demo.dto.PostResponseDTO;
import com.example.demo.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.*;

/**
 * @Author Eric
 * @Description
 * @Since 22. 9. 4.
 **/
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/cursor")
public class CursorController {

    private final PostService postService;

    @GetMapping
    public Page<PostResponseDTO> getCursorPage(CursorPageRequestDTO pageRequestDTO, @RequestParam Long postCursorId) throws Exception{
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Page<PostResponseDTO> result = postService.getCursorPosts(pageRequestDTO.of(),postCursorId);

        stopWatch.stop();

        System.out.println("Cursor를 이용한 페이징 수행시간(MS) : " + stopWatch.getTotalTimeMillis());
        return result;
    }


}
