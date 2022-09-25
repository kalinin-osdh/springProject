package kalinin.entity;

import javax.persistence.*;
import javax.persistence.Entity;

import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "User", schema = "app")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(name = "Name", nullable = false)
    private String name;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private Set<Post> posts;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private Set<Comment> comments;

    public User() {

    }

    public User(Integer id, String name, Set<Post> posts, Set<Comment> comments) {
        this.id = id;
        this.name = name;
        this.posts = posts;
        this.comments = comments;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Post> getPosts() {
        return posts;
    }

    public void setPosts(Set<Post> posts) {
        this.posts = posts;
    }

    public Set<Comment> getComments() {
        return comments;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id.equals(user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}