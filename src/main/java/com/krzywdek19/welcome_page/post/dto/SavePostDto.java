package com.krzywdek19.welcome_page.post.dto;

import com.krzywdek19.welcome_page.post.Post;
import lombok.Data;

import java.util.List;

@Data
public class SavePostDto {
    private String title;
    private String content;
    private String[] photoUrls;

    public Post toPost(){
        return Post.builder()
                .title(title)
                .content(content)
                .photoUrls(List.of(photoUrls))
                .build();
    }
}
