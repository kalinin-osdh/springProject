package kalinin.entity;

import javax.persistence.*;
import javax.persistence.Entity;

import java.sql.Time;

@Entity
@Table(name = "Post", schema = "app")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(name = "Name", nullable = false)
    private String name;

    @Column(name = "Description", nullable = false)
    private String description;

    @Column(name = "Time", nullable = false)
    private Time time;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "UserId", nullable = false)
    private User user;

    public Post() {

    }

    public Post(Integer id, String name, String description, java.sql.Time time, kalinin.entity.User user) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.time = time;
        this.user = user;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public java.sql.Time getTime() {
        return time;
    }

    public void setTime(java.sql.Time time) {
        this.time = time;
    }

    public kalinin.entity.User getUser() {
        return user;
    }

    public void setUser(kalinin.entity.User user) {
        this.user = user;
    }
}
