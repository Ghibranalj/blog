package xyz.ghibran.blog.data;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Post
 */
@Entity
@Table(name = "posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private long id;

    private final String url;
    private final String title;

    @Lob
    private final String content;

    private final String thumbnailURL;

    @Temporal(TemporalType.TIMESTAMP)
    private final Date date;

    public Post() {
        this(null, null, null, null, null);
    }

    public Post(String url, String title, String content, String thumbnailURL, Date date) {
        this.url = url;
        this.title = title;
        this.content = content;
        this.thumbnailURL = thumbnailURL;
        this.date = date;
    }

    public long getId() {
        return this.id;
    }

    public String getUrl() {
        return this.url;
    }

    public String getTitle() {
        return this.title;
    }

    public String getContent() {
        return this.content;
    }

    public String getThumbnailURL() {
        return this.thumbnailURL;
    }

    public Date getDate() {
        return this.date;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Post)) {
            return false;
        }
        Post post = (Post) o;
        return id == post.id && Objects.equals(url, post.url) && Objects.equals(title, post.title)
                && Objects.equals(content, post.content) && Objects.equals(thumbnailURL, post.thumbnailURL)
                && Objects.equals(date, post.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, url, title, content, thumbnailURL, date);
    }

    @Override
    public String toString() {
        return "{" + " id='" + getId() + "'" + ", url='" + getUrl() + "'" + ", title='" + getTitle() + "'"
                + ", content='" + getContent() + "'" + ", thumbnailURL='" + getThumbnailURL() + "'" + ", date='"
                + getDate() + "'" + "}";
    }

}