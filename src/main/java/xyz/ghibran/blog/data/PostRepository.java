package xyz.ghibran.blog.data;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

/**
 * PostRepository
 */
public interface PostRepository extends CrudRepository<Post, Long> {

    public List<Post> findAllByOrderByIdAsc();

    public Post findByUrl(String url);
}