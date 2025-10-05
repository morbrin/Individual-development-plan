package org.example.mapper;

import org.example.dto.AttributeDto;
import org.example.dto.UserDto;
import org.example.entity.AttributeEntity;
import org.example.entity.UserEntity;
import org.mapstruct.Mapper;

@Mapper
public interface UserMapper {
    UserDto toDto(UserEntity userEntity);

    UserEntity toEntity(UserDto userDto);

    AttributeDto toDto(AttributeEntity attributeEntity);

    AttributeEntity toEntity(AttributeDto attributeDto);
}
