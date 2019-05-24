package xyz.ghibran.blog.data;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

/**
 * CommentRepository
 */
public interface CommentRepository extends CrudRepository<Comment, Long> {

    public List<Comment> findAllByPost(Post post);
}