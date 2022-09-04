package com.example.demo.repository.impl;
import static com.example.demo.domain.QPost.post;
import com.example.demo.dto.PostResponseDTO;
import com.example.demo.repository.PostRepositoryCustom;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @Author Eric
 * @Description
 * @Since 22. 9. 4.
 **/
@RequiredArgsConstructor
public class PostRepositoryImpl implements PostRepositoryCustom {
    private final JPAQueryFactory queryFactory;

    @Override
    public Page<PostResponseDTO> getOffsetPosts(Pageable pageable) {
        List<PostResponseDTO> results = queryFactory
                .select(Projections.bean(PostResponseDTO.class,
                        post.id,
                        post.title,
                        post.detail))
                .from(post)
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        return new PageImpl<>(results, pageable, results.size());
    }

    @Override
    public Page<PostResponseDTO> getCursorPosts(Pageable pageable, Long cursorIdx) {

        List<PostResponseDTO> results = queryFactory
                .select(Projections.bean(PostResponseDTO.class,
                        post.id,
                        post.title,
                        post.detail))
                .from(post)
                .where(ltPostId(cursorIdx))
                .limit(pageable.getPageSize())
                .fetch();

        return new PageImpl<>(results, pageable, results.size());
    }

    private BooleanExpression ltPostId(Long cursorIdx) {
        if(cursorIdx.equals(0L)) {
            return null;
        }
        return post.id.gt(cursorIdx);
    }

}
