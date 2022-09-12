package kalinin.model;

import jakarta.persistence.*;
import jakarta.persistence.Entity;

import java.sql.Time;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer Id;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "PostComment",
    joinColumns = {@JoinColumn(name = "CommentId")},
    inverseJoinColumns = {@JoinColumn(name = "PostId")})
    Set<Comment> Comments = new HashSet<>();

    @Column(name = "Name")
    private String Name;

    @Column(name = "Description")
    private String Description;

    @Column(name = "Time")
    private Time Time;

    @ManyToOne
    @JoinColumn(name = "Id", nullable = false)
    private User User;

    public  Post(){

    }

    public Post(Integer id, Set<Comment> comments, String name, String description, java.sql.Time time, kalinin.model.User user) {
        Id = id;
        Comments = comments;
        Name = name;
        Description = description;
        Time = time;
        User = user;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public Set<Comment> getComments() {
        return Comments;
    }

    public void setComments(Set<Comment> comments) {
        Comments = comments;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public java.sql.Time getTime() {
        return Time;
    }

    public void setTime(java.sql.Time time) {
        Time = time;
    }

    public kalinin.model.User getUser() {
        return User;
    }

    public void setUser(kalinin.model.User user) {
        User = user;
    }
}
