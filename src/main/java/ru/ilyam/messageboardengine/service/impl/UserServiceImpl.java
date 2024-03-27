package ru.ilyam.messageboardengine.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.ilyam.messageboardengine.dtos.user.CreateUserDto;
import ru.ilyam.messageboardengine.dtos.user.ReadUserDto;
import ru.ilyam.messageboardengine.dtos.user.UsersResponseDto;
import ru.ilyam.messageboardengine.mapper.UserMapper;
import ru.ilyam.messageboardengine.repository.UserRepository;
import ru.ilyam.messageboardengine.service.UserService;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public void create(CreateUserDto userDto) {
        userRepository.save(userMapper.toEntity(userDto));
    }

    @Override
    public UsersResponseDto getAll() {
        return new UsersResponseDto(userRepository.findAll().stream()
                .map(userMapper::toDto)
                .toList());
    }


    @Override
    public ReadUserDto findById(Long id) {
        return userMapper.toDto(userRepository.findById(id).orElseThrow());
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public ReadUserDto updateUser(Long userId, CreateUserDto requestDto) {
        return null;
    }
}
