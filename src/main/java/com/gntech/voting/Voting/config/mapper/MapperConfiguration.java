package com.gntech.voting.Voting.config.mapper;

import org.mapstruct.Builder;
import org.mapstruct.MapperConfig;

@MapperConfig(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface MapperConfiguration {
}
