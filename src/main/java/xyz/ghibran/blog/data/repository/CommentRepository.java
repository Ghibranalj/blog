package xyz.ghibran.blog.data.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import xyz.ghibran.blog.data.Comment;
import xyz.ghibran.blog.data.Post;

/**
 * CommentRepository
 */
public interface CommentRepository extends CrudRepository<Comment, Long> {

    public List<Comment> findAllByPost(Post post);
}