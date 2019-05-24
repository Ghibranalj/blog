package xyz.ghibran.blog.data;

import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * DataLoader
 */
@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    PostRepository postRepo;
    @Autowired
    PostSectionRepository sectionRepo;
    @Autowired
    CommentRepository commentRepo;

    @Override
    public void run(String... args) throws Exception {
        var logger = LogManager.getLogger(DataLoader.class);
        try {
            extracted();

        } catch (Exception e) {
            logger.error(e);
        }

    }

    private void extracted() {
        String thumbnailURL = "https://raw.githubusercontent.com/CreeperExplosion/blog-images/master/orange-minimalism.jpg";
        String lorem = "Lorem ipsum dolor, sit amet consectetur adipisicing elit. Qui temporibus vel eligendi esse necessitatibus? Animi, soluta voluptate nemo cupiditate quaerat consequatur consectetur quis nobis accusamus placeat quibusdam, nulla quos aliquid laboriosam! Quos quibusdam";
        String title = "Vacation to the land of spring MVC and thymleaf";

        Date date = Calendar.getInstance().getTime();

        var sections = new LinkedList<PostSection>();

        for (int i = 0; i < 5; i++) {
            var section = new PostSection(i + "section", lorem);
            sectionRepo.save(section);
            sections.add(section);
        }

        for (int i = 0; i < 10; i++) {
            var number = i + "";
            var post = new Post(number, title, lorem, thumbnailURL, date, sections);

            postRepo.save(post);

            for (int j = 0; j < 5; j++) {
                var comment = new Comment("user" + j, "nice work " + i * j, date, post);
                commentRepo.save(comment);
            }
        }
    }
}