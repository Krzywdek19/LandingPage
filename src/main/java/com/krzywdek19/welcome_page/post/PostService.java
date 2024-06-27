package com.krzywdek19.welcome_page.post;

import com.krzywdek19.welcome_page.post.dto.SavePostDto;
import com.krzywdek19.welcome_page.post.errors.PostDoesNotExist;

public interface PostService {
    void createPost(SavePostDto dto);
    void deletePost(String title) throws PostDoesNotExist;

    void updatePost(String title, SavePostDto dto) throws PostDoesNotExist;

    Post getPost(String title) throws PostDoesNotExist;

}
