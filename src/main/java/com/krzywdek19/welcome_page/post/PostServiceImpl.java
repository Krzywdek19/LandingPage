package com.krzywdek19.welcome_page.post;

import com.krzywdek19.welcome_page.post.dto.SavePostDto;
import com.krzywdek19.welcome_page.post.errors.PostDoesNotExist;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService{
    private final PostRepository repository;
    @Override
    public void createPost(SavePostDto dto) {
        repository.save(
                dto.toPost()
        );
    }

    @Override
    public void deletePost(String title) throws PostDoesNotExist {
        repository.delete(repository.findByTitle(title).orElseThrow(PostDoesNotExist::new));
    }

    @Override
    public void updatePost(String title, SavePostDto dto) throws PostDoesNotExist {
        var updatingPost = repository.findByTitle(title).orElseThrow(PostDoesNotExist::new);
        var post = dto.toPost();
        post.setId(updatingPost.getId());
        repository.save(post);
    }

    @Override
    public Post getPost(String title) throws PostDoesNotExist {
        return repository.findByTitle(title).orElseThrow(PostDoesNotExist::new);
    }
}
