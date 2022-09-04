package com.example.demo.controller;

import com.example.demo.dto.OffsetPageRequestDTO;
import com.example.demo.dto.PostResponseDTO;
import com.example.demo.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @Author Eric
 * @Description
 * @Since 22. 9. 4.
 **/
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/offset")
public class OffsetController {

    private final PostService postService;

    @GetMapping
    public Page<PostResponseDTO> getOffsetPage(OffsetPageRequestDTO pageRequestDTO) throws Exception{
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Page<PostResponseDTO> result = postService.getOffsetPosts(pageRequestDTO.of());

        stopWatch.stop();
        System.out.println("Offset을 이용한 페이징 수행시간(MS) : " + stopWatch.getTotalTimeMillis());
        return result;
    }
}
