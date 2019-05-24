package xyz.ghibran.blog.data;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;

/**
 * Post
 */
@Entity
public class PostSection {

    @Id
    @GeneratedValue
    private long id;

    private final String title;

    @Lob
    private final String content;

    public PostSection() {
        this(null, null);
    }

    public PostSection(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public long getId() {
        return this.id;
    }

    public String getTitle() {
        return this.title;
    }

    public String getContent() {
        return this.content;
    }

    public PostSection id(long id) {
        this.id = id;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof PostSection)) {
            return false;
        }
        PostSection postSection = (PostSection) o;
        return id == postSection.id && Objects.equals(title, postSection.title)
                && Objects.equals(content, postSection.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, content);
    }

    @Override
    public String toString() {
        return "{" + " id='" + getId() + "'" + ", title='" + getTitle() + "'" + ", content='" + getContent() + "'"
                + "}";
    }

}