package kalinin.service;

import kalinin.dto.UserDto;
import kalinin.entity.User;

public interface UserService extends Service<User, UserDto, Integer>{
    UserDto findByName(String name);
}
