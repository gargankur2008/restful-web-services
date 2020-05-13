package com.ankur.springboot.web.restfulwebservices.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
public class PostResource {

    @Autowired
    private PostDaoService postDaoService;

    @GetMapping(path = "/users/{id}/posts")
    public List<Post> getAllUserPosts(@PathVariable int id) {
        List<Post> postList = postDaoService.getAllPosts(id);
        if(postList == null) throw new PostNotFoundException("UserId-"+id);
        return postList;
    }

    @GetMapping(path = "/users/{id}/posts/{post_id}")
    public Post getPost(@PathVariable int id, @PathVariable int post_id) {
        Post post = postDaoService.getPost(id, post_id);
        if(post == null) throw new PostNotFoundException("UserId-"+id+" and Post_Id="+post_id);
        return post;
    }

    @PostMapping(path = "/users/{id}/posts")
    public ResponseEntity<Object> newPost(@PathVariable int id,@Valid @RequestBody Post post) {
        Post savedPost = postDaoService.save(post);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{post_id}").buildAndExpand(savedPost.getId()).toUri();
        return ResponseEntity.created(location).build();
    }
}
