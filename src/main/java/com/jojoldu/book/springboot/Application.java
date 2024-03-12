package com.jojoldu.book.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@EnableJpaAuditing // JPA Auditing 활성화
@SpringBootApplication // 여기부터 설정을 읽어가기 때문에 이 클래스는 항상 프로젝트에 최상단에 위치
//@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class Application { // 앞으로 만들 프로젝트의 메인 클래스
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args); // 내장 WAS 실행 -> 톰캣 설치 x, Jar파일로 실행
    }
}
