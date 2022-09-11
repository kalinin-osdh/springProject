package model;

import jakarta.persistence.*;
import jakarta.persistence.Entity;

import java.sql.Time;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Comment")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer Id;

    @ManyToMany(mappedBy = "Comments")
    private Set<Post> Posts = new HashSet<>();

    @Column(name = "Text")
    private String Text;

    @Column(name = "Time")
    private Time Time;

    @ManyToOne
    @JoinColumn(name = "Id", nullable = false)
    private User User;

    public Comment() {
    }

    public Comment(Integer id, Set<Post> posts, String text, java.sql.Time time, model.User user) {
        Id = id;
        Posts = posts;
        Text = text;
        Time = time;
        User = user;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public Set<Post> getPosts() {
        return Posts;
    }

    public void setPosts(Set<Post> posts) {
        Posts = posts;
    }

    public String getText() {
        return Text;
    }

    public void setText(String text) {
        Text = text;
    }

    public java.sql.Time getTime() {
        return Time;
    }

    public void setTime(java.sql.Time time) {
        Time = time;
    }

    public model.User getUser() {
        return User;
    }

    public void setUser(model.User user) {
        User = user;
    }
}
