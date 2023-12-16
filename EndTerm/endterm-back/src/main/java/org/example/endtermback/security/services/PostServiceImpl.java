package org.example.endtermback.security.services;

import lombok.RequiredArgsConstructor;
import org.example.endtermback.models.Post;
import org.example.endtermback.models.User;
import org.example.endtermback.payload.PostRequest;
import org.example.endtermback.repository.PostRepository;
import org.example.endtermback.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService{
    private final PostRepository postRepository;
    private final UserRepository userRepository;

    @Override
    public ResponseEntity<?> getAllPosts() {
        List<Post> listOfPosts = postRepository.findAll();
        return new ResponseEntity<>(listOfPosts, HttpStatus.OK);
    }

    @Override
    public String createPost(PostRequest postRequest) {

        Post post = new Post();
        post.setTitle(postRequest.getTitle());
        post.setDate(new Date());
        post.setArticle(postRequest.getArticle());
        postRepository.save(post);
        return "Success!!!";
    }

    @Override
    public Post getPostById(Long id) {
        return postRepository.findById(id).orElseThrow(() -> new NotFoundException("Not Found"));
    }

    @Override
    public String editPost(PostRequest postRequest) {
        Post post = postRepository.findById(postRequest.getId()).orElseThrow(() -> new NotFoundException("post not found" + postRequest.getId()));
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String email = userDetails.getUsername();
        User user = userRepository.findByEmail(email).orElseThrow(() ->
                new NotFoundException("user with email - " + email));
        post.setTitle(postRequest.getTitle());
        post.setDate(new Date());
        post.setArticle(postRequest.getArticle());
        postRepository.save(post);
        return "Success!!!";
    }

    @Override
    public String deletePost(Long id) {
        postRepository.deleteById(id);
        return "Post Removed!!!";
    }
}
