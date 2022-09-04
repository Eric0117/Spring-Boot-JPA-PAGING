package com.example.demo.config;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.Statement;


/**
 * @Author Eric
 * @Description
 * @Since 22. 9. 4.
 **/
@Component
@RequiredArgsConstructor
public class H2Runner implements ApplicationRunner {

    private final DataSource dataSource;

    @Override
    public void run( ApplicationArguments args ) {
        try {
            Connection connection = dataSource.getConnection();
            System.out.println("========= APPLICATION START TO INSERT DUMMY DATA... HOLD ON.... =========");

            Statement statement = connection.createStatement();
            StringBuilder sqlSb = new StringBuilder();

            for(int i=1; i<=10000; i++) {
                sqlSb.append("INSERT INTO POST(TITLE, DETAIL) VALUES ('TITLE ").append(i).append("','DETAIL ").append(i).append(" ');");
            }
            statement.executeUpdate(sqlSb.toString());

            System.out.println("========= APPLICATION READY TO START =========");
        } catch( Exception e ) {
            e.printStackTrace();
        }
    }
}
