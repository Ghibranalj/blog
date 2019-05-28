package xyz.ghibran.blog.data.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import xyz.ghibran.blog.data.Post;

/**
 * PostRepository
 */
public interface PostRepository extends CrudRepository<Post, Long> {

    public List<Post> findAllByOrderByIdAsc();

    public Post findByUrl(String url);
}