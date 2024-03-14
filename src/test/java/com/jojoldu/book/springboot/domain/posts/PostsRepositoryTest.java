package com.jojoldu.book.springboot.domain.posts;

import ch.qos.logback.core.util.Loader;
import com.jojoldu.book.springboot.domain.posts.Posts;
import com.jojoldu.book.springboot.domain.posts.PostsRepository;
import com.jojoldu.book.springboot.domain.BaseTimeEntity;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class PostsRepositoryTest {

    @Autowired
    PostsRepository postsRepository;

    @AfterEach // Junit에서 단위 테스트가 끝날 때마다 수행되는 메소드를 지정
    public void cleanUp() {
        postsRepository.deleteAll();
    }

    @Test
    @DisplayName("게시글 저장 불러오기")
    public void loadPostSave() throws Exception {
        // given
        String title = "테스트 게시물";
        String content = "테스트 본문";

        // 테이블 posts에 insert/update 쿼리 실행
        postsRepository.save(
                Posts.builder()
                        .title(title)
                        .content(content)
                        .author("yujin071610@gmail.com")
                        .build());

        // when
        // 테이블 posts에 있는 모든 데이터 조회
        List<Posts> list = postsRepository.findAll();

        // then
        Posts post = list.get(0);
        assertThat(post.getTitle()).isEqualTo(title);
        assertThat(post.getContent()).isEqualTo(content);
    }

    @Test
    public void registerBaseTimeEntity() {
        // given
        LocalDateTime now = LocalDateTime.of(2024,3, 12, 0, 0, 0);
        postsRepository.save(Posts.builder()
                .title("title")
                .content("content")
                .author("author")
                .build());


        // when
        List<Posts> postsList = postsRepository.findAll();

        // then
        Posts posts = postsList.get(0);

        System.out.println(">>>>>>>>> createDate="+posts.getCreatedDate()+", modifiedDate=" + posts.getModifiedDate());

        assertThat(posts.getCreatedDate()).isAfter(now);
        assertThat(posts.getModifiedDate()).isAfter(now);
    }
}

