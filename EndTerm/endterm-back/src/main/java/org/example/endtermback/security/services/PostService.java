package org.example.endtermback.security.services;

import org.example.endtermback.models.Post;
import org.example.endtermback.payload.PostRequest;
import org.springframework.http.ResponseEntity;

public interface PostService {


    ResponseEntity<?> getAllPosts();

    String createPost(PostRequest postRequest);

    Post getPostById(Long id);

    String editPost(PostRequest request);

    String deletePost(Long id);
}
