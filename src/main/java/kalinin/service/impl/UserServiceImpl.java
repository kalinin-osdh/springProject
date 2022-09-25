package kalinin.service.impl;

import kalinin.dto.UserDto;
import kalinin.entity.User;
import kalinin.mapper.impl.UserMapper;
import kalinin.repository.UserRepository;
import kalinin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
        userMapper = UserMapper.getInstance();
    }

    @Override
    public UserDto insert(User user) {
        return userMapper.toDto(userRepository.save(user));
    }

    @Override
    public UserDto update(Integer id, User user) {
        user.setId(id);

        return userMapper.toDto(user);
    }

    @Override
    public UserDto deleteById(Integer id) {
        User user = userRepository.findById(id).orElse(null);

        if (user!=null){
            userRepository.deleteById(id);
        }
        return userMapper.toDto(user);
    }

    @Override
    public List<UserDto> findAll() {
        return userRepository.findAll().
                stream().
                map(userMapper::toDto).
                collect(Collectors.toList());
    }

    @Override
    public UserDto findById(Integer id) {
        return userRepository.findById(id).map(userMapper::toDto).orElse(null);
    }


    @Override
    public UserDto findByName(String name) {
        return userRepository.findByName(name).map(userMapper::toDto).orElse(null);
    }
}
