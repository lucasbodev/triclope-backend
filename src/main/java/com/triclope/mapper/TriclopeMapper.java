package com.triclope.mapper;

import com.triclope.dto.request.TriclopeCreationRequest;
import com.triclope.dto.response.TriclopeDto;
import com.triclope.dto.request.TriclopeUpdateRequest;
import com.triclope.model.TriclopeDb;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper 
public abstract class TriclopeMapper {

    @Mapping( target = "members", ignore = true)
    @Mapping( target = "id", ignore = true)
    @Mapping( target = "creationDate", ignore = true)
    @Mapping( target = "participations", ignore = true)
    @Mapping( target = "createdBy", ignore = true)
    public abstract TriclopeDb toCreateDb(TriclopeCreationRequest dto);

    @Mapping( target = "members", ignore = true)
    @Mapping( target = "id", ignore = true)
    @Mapping( target = "creationDate", ignore = true)
    @Mapping( target = "participations", ignore = true)
    @Mapping( target = "createdBy", ignore = true)
    public abstract TriclopeDb toUpdateDb (TriclopeUpdateRequest dto);

    public abstract TriclopeDto toDto(TriclopeDb db);

    public abstract List<TriclopeDto> toList(List<TriclopeDb> db);



}
