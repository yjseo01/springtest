package com.jojoldu.book.springboot.domain.posts;

import com.jojoldu.book.springboot.domain.BaseTimeEntity;
import lombok.Builder; // 해당 클래스의 빌더 패턴 클래스를 생성, 생성자 상단에 선언 시 생성자에 포함된 필드만 필더에 포함
import lombok.Getter; // 클래스 내 모든 필드의 Getter 메소드 자동 생성
import lombok.NoArgsConstructor; // 기본 생성자 자동 추가 (public Posts() {})

import jakarta.persistence.*;

@Getter // 클래스 내 모든 필드의 Getter 메소드 자동 생성
@NoArgsConstructor // 기본 생성자 자동 추가 (public Posts() {})
@Entity // 테이블과 링크될 클래스임을 나타냄
public class Posts extends BaseTimeEntity {
    @Id // 해당 테이블의 PK 필드를 나타냄
    @GeneratedValue(strategy = GenerationType.IDENTITY) // PK의 생성 규칙을 나타냄
    private Long id;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    // 업데이트 메서드 추가
    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
