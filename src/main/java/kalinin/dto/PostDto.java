package kalinin.dto;

import java.sql.Time;
import java.util.Objects;

public class PostDto {
    private Integer id;
    private String name;
    private String description;
    private Time time;
    private Integer userId;

    public PostDto(Integer id, String name, String description, Time time, Integer userId) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.time = time;
        this.userId = userId;
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

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PostDto postDto = (PostDto) o;
        return Objects.equals(id, postDto.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
