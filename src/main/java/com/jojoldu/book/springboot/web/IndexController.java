package com.jojoldu.book.springboot.web;

import com.jojoldu.book.springboot.web.dto.*;
import com.jojoldu.book.springboot.service.PostsService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RequiredArgsConstructor
@Controller
public class IndexController {
    /*
    @GetMapping("/")
    public String index() {
        return "index";
    }
    * */

    private final PostsService postsService;

    // 서버 템플릿 엔진에서 사용할 수 있는 객체 저장
    // postsService.findAllDesc()로 가져온 결과를 posts로 index.mustache에 전달

    // 조회
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("posts", postsService.findAllDesc());
        return "index";
    }

    // 등록
    @GetMapping("/posts/save")
    public String postsSave() {
        return "posts-save";
    }

    // 수정
    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model) {
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post", dto);

        return "posts-update";
    }
}
