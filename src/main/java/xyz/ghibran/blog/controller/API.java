package xyz.ghibran.blog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import xyz.ghibran.blog.data.Comment;
import xyz.ghibran.blog.data.Post;
import xyz.ghibran.blog.service.BlogVisitorService;

/**
 * API
 */
@RestController
public class API {

    @Autowired
    BlogVisitorService blogService;

    @GetMapping("/api/blog/{url}")
    public Post getPost(@PathVariable String url) {
        return blogService.getPost(url);
    }

    @GetMapping("/api/comment/{url}")
    public List<Comment> getComments(@PathVariable String url) {
        return blogService.getCommentInPost(blogService.getPost(url));
    }

}