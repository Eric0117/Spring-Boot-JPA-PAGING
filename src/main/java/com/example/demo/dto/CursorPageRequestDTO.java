package com.example.demo.dto;

import org.springframework.data.domain.Sort;

import javax.validation.constraints.NotNull;

/**
 * @Author Eric
 * @Description
 * @Since 22. 9. 4.
 **/
public class CursorPageRequestDTO {
    private Long postCursorId;
    @NotNull(message = "size 필수 입력 값입니다.")
    private int size;
    @NotNull(message = "direction 필수 입력 값입니다.")
    private Sort.Direction direction;

    public CursorPageRequestDTO(){
        this.postCursorId = 0L;
        this.size = 10;
        this.direction = Sort.Direction.DESC;
    }

    public void setSize(int size) {
        int DEFAULT_SIZE = 10;
        int MAX_SIZE = 200;
        this.size = size > MAX_SIZE ? DEFAULT_SIZE : size;
    }

    public void setDirection(Sort.Direction direction) {
        this.direction = direction;
    }
    // getter

    public org.springframework.data.domain.PageRequest of() {
        return org.springframework.data.domain.PageRequest.of(0, size, direction, "created_date");
    }
}
