package com.example.converter;

import com.example.dto.UserDTO;
import com.example.entity.UserEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component//khong co cai nay hk dung dc Autowired(DI)
public class UserConverter {
    @Autowired
    private ModelMapper modelMapper;

    public UserDTO convertToDto(UserEntity entity) {
        UserDTO result = modelMapper.map(entity, UserDTO.class);
        return result;
    }

    public UserEntity convertToEntity(UserDTO dto) {
        UserEntity result = modelMapper.map(dto, UserEntity.class);
        return result;
    }
}
