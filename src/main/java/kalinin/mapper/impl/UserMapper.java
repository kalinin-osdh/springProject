package kalinin.mapper.impl;

import kalinin.dto.CommentDto;
import kalinin.dto.PostDto;
import kalinin.dto.UserDto;
import kalinin.entity.Comment;
import kalinin.entity.Post;
import kalinin.entity.User;
import kalinin.mapper.Mapper;

import java.util.Set;
import java.util.stream.Collectors;

public class UserMapper implements Mapper<User, UserDto> {

    private static UserMapper mapper;

    private final PostMapper postMapper;
    private final CommentMapper commentMapper;

    private UserMapper() {
        postMapper = PostMapper.getInstance();
        commentMapper = CommentMapper.getInstance();
    }

    public static UserMapper getInstance() {
        if (mapper == null) {
            mapper = new UserMapper();
        }

        return mapper;
    }


    @Override
    public User toEntity(UserDto userDto) {
        Set<Post> posts = null;
        Set<Comment> comments = null;

        Set<PostDto> postsDto = userDto.getPosts();
        Set<CommentDto> commentsDto = userDto.getComments();

        if (postsDto != null) {
            posts = postsDto.stream().map(postMapper::toEntity).collect(Collectors.toSet());
        }

        if (postsDto != null) {
            comments = commentsDto.stream().map(commentMapper::toEntity).collect(Collectors.toSet());
        }

        return new User(userDto.getId(), userDto.getName(), posts, comments);
    }

    @Override
    public UserDto toDto(User user) {
        Set<PostDto> postsDto = null;
        Set<CommentDto> commentsDto = null;

        Set<Post> posts = user.getPosts();
        Set<Comment> comments = user.getComments();

        if (posts != null) {
            postsDto = posts.stream().map(postMapper::toDto).collect(Collectors.toSet());
        }
        if (comments != null) {
            commentsDto = comments.stream().map(commentMapper::toDto).collect(Collectors.toSet());
        }

        return new UserDto(user.getId(), user.getName(), postsDto, commentsDto);
    }
}
