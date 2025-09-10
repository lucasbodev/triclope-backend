package com.triclope.mapper;

import com.triclope.dto.response.ParticipationDto;
import com.triclope.model.ParticipationDb;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {UserMapper.class})
public abstract class ParticipationMapper {

    @Mapping(target = "triclopeId", source = "triclope.id")
    public abstract ParticipationDto toDto(ParticipationDb participationDb);

    public abstract List<ParticipationDto> toList(List<ParticipationDb> participationDbs);
}