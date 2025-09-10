package com.triclope.mapper;

import com.triclope.dto.response.UserDto;
import com.triclope.model.UserDb;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public abstract class UserMapper {

    public abstract UserDto toDto(UserDb userDb);

    public abstract List<UserDto> toList(List<UserDb> userDbs);

}