package web;

import com.jojoldu.book.springboot.domain.posts.PostsRepository;
import com.jojoldu.book.springboot.service.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import web.dto.PostsResponseDto;

@RequiredArgsConstructor
@Controller
public class IndexController {

    // 머스테치 스타터 덕분에 앞의 경로(src/main/resources/templates)와 뒤의 파일 확장자(.mustache)가 자동으로 지정
    /*
    @GetMapping("/")
    public String index() {
        return "index";
    }
    */

    private final PostsService postsService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAllAttribute("posts", postsService.findAllDesc());
        return "index";
    }

    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model) {
        PostsResponseDto dto = postsService.findById(id);

        return "posts-update";
    }

}
