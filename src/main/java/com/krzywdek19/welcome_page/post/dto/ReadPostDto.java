package com.krzywdek19.welcome_page.post.dto;

import com.krzywdek19.welcome_page.post.Post;
import lombok.Data;
import java.util.List;

@Data
public class ReadPostDto {
    private String title;
    private String content;
    private List<String> urls;

    public ReadPostDto(Post post) {
        this.title = post.getTitle();
        this.content = post.getContent();
        this.urls = post.getPhotoUrls();
    }
}
