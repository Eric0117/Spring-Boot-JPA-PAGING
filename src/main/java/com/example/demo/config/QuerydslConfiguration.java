package com.example.demo.config;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @Author Eric
 * @Description
 * @Since 22. 9. 4.
 **/
@Configuration
public class QuerydslConfiguration {
    @PersistenceContext
    private EntityManager entityManager;

    @Bean
    public JPAQueryFactory jpaQueryFactory() { return new JPAQueryFactory(entityManager); }
}
