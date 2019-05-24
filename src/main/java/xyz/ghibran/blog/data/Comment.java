package xyz.ghibran.blog.data;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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

    private final String name;

    @Lob
    private final String content;

    @Temporal(TemporalType.TIMESTAMP)
    private final Date date;

    @ManyToOne
    private final Post post;

    public Comment() {
        this(null, null, null, null);
    }

    public Comment(String name, String content, Date date, Post post) {
        this.name = name;
        this.content = content;
        this.date = date;
        this.post = post;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return this.name;
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
        return comment.getId() == id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, content, date, post);
    }

    @Override
    public String toString() {
        return "{" + " name='" + getName() + "'" + ", content='" + getContent() + "'" + ", date='" + getDate() + "'"
                + ", post='" + getPost() + "'" + "}";
    }

}