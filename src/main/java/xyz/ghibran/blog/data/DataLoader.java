package xyz.ghibran.blog.data;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * DataLoader
 */
@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    PostRepository repo;

    @Override
    public void run(String... args) throws Exception {

        String thumbnailURL = "https://raw.githubusercontent.com/CreeperExplosion/blog-images/master/3840x2160-baby-blue-solid-color-background.jpg";
        String lorem = "Lorem ipsum dolor, sit amet consectetur adipisicing elit. Qui temporibus vel eligendi esse necessitatibus? Animi, soluta voluptate nemo cupiditate quaerat consequatur consectetur quis nobis accusamus placeat quibusdam, nulla quos aliquid laboriosam! Quos quibusdam a dignissimos nisi qui blanditiis praesentium deleniti, dolore, facilis fugit sint eaque quo temporibus. Nulla, temporibus veniam!";

        for (int i = 0; i < 10; i++) {
            var number = i + "";
            var post = new Post(number, number, lorem, thumbnailURL, Calendar.getInstance().getTime());
            repo.save(post);
        }

    }
}