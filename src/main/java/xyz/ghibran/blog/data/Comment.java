package xyz.ghibran.blog.data;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Comment
 */
@Entity
@Table(name = "comments")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private long id;

    @Lob
    private final String content;

    @Temporal(TemporalType.TIMESTAMP)
    private final Date date;

    @ManyToOne
    private final Post post;

    public Comment() {
        this(null, null, null);
    }

    public Comment(String content, Date date, Post post) {
        this.content = content;
        this.date = date;
        this.post = post;
    }

    public long getId() {
        return this.id;
    }

    public String getContent() {
        return this.content;
    }

    public Date getDate() {
        return this.date;
    }

    public Post getPost() {
        return this.post;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Comment)) {
            return false;
        }
        Comment comment = (Comment) o;
        return id == comment.id && Objects.equals(content, comment.content) && Objects.equals(date, comment.date)
                && Objects.equals(post, comment.post);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, content, date, post);
    }

    @Override
    public String toString() {
        return "{" + " id='" + getId() + "'" + ", content='" + getContent() + "'" + ", date='" + getDate() + "'"
                + ", post='" + getPost() + "'" + "}";
    }

}