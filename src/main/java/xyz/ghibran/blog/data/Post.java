package xyz.ghibran.blog.data;

import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
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
    private final String subTitle;

    private final String thumbnailURL;

    @Temporal(TemporalType.TIMESTAMP)
    private final Date date;

    @ManyToMany
    private final List<PostSection> sections;

    public Post() {
        this(null, null, null, null, null, null);
    }

    public Post(String url, String title, String subTitle, String thumbnailURL, Date date, List<PostSection> sections) {
        this.url = url;
        this.title = title;
        this.subTitle = subTitle;
        this.thumbnailURL = thumbnailURL;
        this.date = date;
        this.sections = sections;
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

    public String getSubTitle() {
        return this.subTitle;
    }

    public String getThumbnailURL() {
        return this.thumbnailURL;
    }

    public Date getDate() {
        return this.date;
    }

    public List<PostSection> getSections() {
        return this.sections;
    }

    public Post id(long id) {
        this.id = id;
        return this;
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
                && Objects.equals(subTitle, post.subTitle) && Objects.equals(thumbnailURL, post.thumbnailURL)
                && Objects.equals(date, post.date) && Objects.equals(sections, post.sections);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, url, title, subTitle, thumbnailURL, date, sections);
    }

    @Override
    public String toString() {
        return "{" + " id='" + getId() + "'" + ", url='" + getUrl() + "'" + ", title='" + getTitle() + "'"
                + ", subTitle='" + getSubTitle() + "'" + ", thumbnailURL='" + getThumbnailURL() + "'" + ", date='"
                + getDate() + "'" + ", sections='" + getSections().toString() + "'" + "}";
    }

}