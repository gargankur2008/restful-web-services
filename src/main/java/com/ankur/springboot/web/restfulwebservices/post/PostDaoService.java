package com.ankur.springboot.web.restfulwebservices.post;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PostDaoService {
    private static List<Post> posts = new ArrayList<>();

    static {
        posts.add(new Post(1,1,"Test 1","Test Description 1"));
        posts.add(new Post(1,2,"Test 2","Test Description 2"));
        posts.add(new Post(1,3,"Test 3","Test Description 3"));
        posts.add(new Post(1,1,"Test 4","Test Description 4"));
        posts.add(new Post(1,3,"Test 5","Test Description 5"));
    }

    public static int postCount = 5;

    public List<Post> getAllPosts(int userId){
        List<Post> postList = new ArrayList<>();
        for (Post post: posts
             ) {
            if(post.getUserId() == userId) postList.add(post);
        }
        return postList;
    }

    public Post getPost(int userId, int postId){
        for (Post post: posts
             ) {
            if(post.getUserId() == userId && post.getId() == postId) return post;
        }
        return null;
    }

    public Post save(Post post) {
        if(post.getId() == null) post.setId(++postCount);
        posts.add(post);
        return post;
    }
}
