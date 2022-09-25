package kalinin.mapper.impl;

import kalinin.dto.CommentDto;
import kalinin.entity.Comment;
import kalinin.mapper.Mapper;

public class CommentMapper implements Mapper<Comment, CommentDto> {

    private static CommentMapper mapper;

    //private final UserMapper userMapper;
    //private final PostMapper postMapper;

    private CommentMapper() {
        //userMapper = UserMapper.getInstance();
        //postMapper = PostMapper.getInstance();
    }

    public static CommentMapper getInstance() {
        if (mapper == null) {
            mapper = new CommentMapper();
        }

        return mapper;
    }

    @Override
    public Comment toEntity(CommentDto commentDto) {
        return null;
    }

    @Override
    public CommentDto toDto(Comment comment) {
        return null;
    }
}
