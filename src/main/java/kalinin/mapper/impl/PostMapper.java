package kalinin.mapper.impl;

import kalinin.dto.PostDto;
import kalinin.entity.Post;
import kalinin.mapper.Mapper;

public class PostMapper implements Mapper<Post, PostDto> {

    private static PostMapper mapper;

    //private final UserMapper userMapper;

    private PostMapper() {
        //userMapper = UserMapper.getInstance();
    }

    public static PostMapper getInstance() {
        if (mapper == null) {
            mapper = new PostMapper();
        }

        return mapper;
    }

    @Override
    public Post toEntity(PostDto postDto) {
        return null;
    }

    @Override
    public PostDto toDto(Post post) {
        return null;
    }
}
