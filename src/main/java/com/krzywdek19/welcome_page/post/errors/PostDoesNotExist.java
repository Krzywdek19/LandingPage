package com.krzywdek19.welcome_page.post.errors;

public class PostDoesNotExist extends Exception{
    public PostDoesNotExist() {
        super("Post with this title doesn't exist");
    }

    public PostDoesNotExist(String message) {
        super(message);
    }
}
