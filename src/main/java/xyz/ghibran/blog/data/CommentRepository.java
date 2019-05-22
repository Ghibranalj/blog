package xyz.ghibran.blog.data;

import org.springframework.data.repository.CrudRepository;

/**
 * CommentRepository
 */
public interface CommentRepository extends CrudRepository<Comment, Long> {

}