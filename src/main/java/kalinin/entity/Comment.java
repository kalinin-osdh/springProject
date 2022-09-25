package kalinin.entity;

import javax.persistence.*;
import javax.persistence.Entity;

import java.sql.Time;


@Entity
@Table(name = "Comment", schema = "app")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(name = "Text", nullable = false)
    private String text;

    @Column(name = "Time", nullable = false)
    private Time time;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "UserId", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "PostId", nullable = false)
    private Post post;

    public Comment() {
    }

    public Comment(Integer id, String text, java.sql.Time time, User user, Post post) {
        this.id = id;
        this.text = text;
        this.time = time;
        this.user = user;
        this.post = post;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public java.sql.Time getTime() {
        return time;
    }

    public void setTime(java.sql.Time time) {
        this.time = time;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

}
