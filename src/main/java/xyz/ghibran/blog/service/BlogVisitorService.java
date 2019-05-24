package xyz.ghibran.blog.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xyz.ghibran.blog.data.Comment;
import xyz.ghibran.blog.data.CommentRepository;
import xyz.ghibran.blog.data.Post;
import xyz.ghibran.blog.data.PostRepository;

/**
 * BlogVisitorService
 * 
 * services blog's visitor
 */
@Service
public class BlogVisitorService {

    @Autowired
    private PostRepository postRepo;
    @Autowired
    private CommentRepository commentRepo;

    /**
     * @param page  page number
     * @param range how many Posts per page
     * @return posts in requested page
     */
    public List<Post> getPostInPage(int page, int range) {

        var value = new LinkedList<Post>();

        var data = postRepo.findAllByOrderByIdAsc();

        int dataSize = data.size();
        int firstIndexOffset = dataSize - (page * range) - 1;
        int lastIndexOffset = dataSize - ((page + 1) * range);

        if (firstIndexOffset < 0)
            return null;
        if (lastIndexOffset < 0)
            lastIndexOffset = 0;
        for (int i = firstIndexOffset; i >= lastIndexOffset; i--) {
            value.add(data.get(i));
        }

        return value;
    }

    public Post getPost(String url) {
        return postRepo.findByUrl(url);
    }

    public List<Comment> getCommentInPost(Post post) {
        var value = new LinkedList<Comment>();
        commentRepo.findAllByPost(post).forEach(value::add);
        return value;
    }

}