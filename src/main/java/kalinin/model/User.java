package kalinin.model;

import jakarta.persistence.*;
import jakarta.persistence.Entity;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "User")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer Id;

    @Column(name = "Name")
    private String Name;

    @OneToMany(mappedBy = "User")
    private Set<Post> Posts = new HashSet<>();

    @OneToMany(mappedBy = "User")
    private Set<Comment> Comments = new HashSet<>();

    public User(){

    }

    public User(Integer id, String name, Set<Post> posts, Set<Comment> comments) {
        Id = id;
        Name = name;
        Posts = posts;
        Comments = comments;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Set<Post> getPosts() {
        return Posts;
    }

    public void setPosts(Set<Post> posts) {
        Posts = posts;
    }

    public Set<Comment> getComments() {
        return Comments;
    }

    public void setComments(Set<Comment> comments) {
        Comments = comments;
    }
}
