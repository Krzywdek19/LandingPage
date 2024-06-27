package com.krzywdek19.welcome_page.post;

import com.krzywdek19.welcome_page.post.dto.ReadPostDto;
import com.krzywdek19.welcome_page.post.dto.SavePostDto;
import com.krzywdek19.welcome_page.post.errors.PostDoesNotExist;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/posts")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    @GetMapping("/{title}")
    public ReadPostDto getByTitle(@PathVariable String title) throws PostDoesNotExist {
        return new ReadPostDto(postService.getPost(title));
    }

    @PostMapping
    public void addPost(@RequestBody SavePostDto dto){
        postService.createPost(dto);
    }

    @PostMapping("/{title}")
    public void updateByTitle(@PathVariable String title, @RequestBody SavePostDto dto) throws PostDoesNotExist {
        postService.updatePost(title, dto);
    }

    @DeleteMapping("/{title}")
    public void deleteByTitle(@PathVariable String title) throws PostDoesNotExist {
        postService.deletePost(title);
    }
}
