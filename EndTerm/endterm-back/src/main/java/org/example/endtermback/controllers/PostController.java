package org.example.endtermback.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.endtermback.models.Post;
import org.example.endtermback.payload.PostRequest;
import org.example.endtermback.security.services.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@Slf4j
@RequestMapping("/api/post")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    @GetMapping("/posts")
    public ResponseEntity<?> getPosts() {
        return postService.getAllPosts();
    }

    @PostMapping("/post/")
    public ResponseEntity<?> createPost (@RequestBody PostRequest postRequest) {
        String post = postService.createPost(postRequest);
        return new ResponseEntity<>(post, HttpStatus.OK);
    }

    @GetMapping("/post/{id}")
    public Post getPostById(@PathVariable Long id) {
        return postService.getPostById(id);
    }

    @PutMapping("/post/edit_post")
    public ResponseEntity<?> editPostText(@RequestBody PostRequest postRequest) {
        String post = postService.editPost(postRequest);
        return new ResponseEntity<>(post, HttpStatus.OK);
    }

    @DeleteMapping("/post/delete_post/{id}")
    public ResponseEntity<?> deletePost(@PathVariable Long id) {
        String res = postService.deletePost(id);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
}
