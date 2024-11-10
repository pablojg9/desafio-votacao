package com.gntech.voting.Voting.adapter.in.resource.mapper;

import com.gntech.voting.Voting.adapter.in.resource.request.VoteRequest;
import com.gntech.voting.Voting.application.core.domain.Vote;
import com.gntech.voting.Voting.application.core.domain.enm.VoteEnum;
import com.gntech.voting.Voting.config.mapper.MapperConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(config = MapperConfiguration.class)
public interface VoteMapper {

  VoteRequest voteToVoteRequest(Vote vote);

  @Mapping(target = "vote", qualifiedByName = "getCheckVote", source = "vote")
  @Mapping(target = "cpf", source = "cpf")
  @Mapping(target = "id", ignore = true)
  @Mapping(target = "agenda", ignore = true)
  Vote voteRequestToVote(VoteRequest voteRequest);

  @Named("getCheckVote")
  default String getCheckVote(String vote) {
    return VoteEnum.valueOf(vote.toUpperCase()).name();
  }
}
