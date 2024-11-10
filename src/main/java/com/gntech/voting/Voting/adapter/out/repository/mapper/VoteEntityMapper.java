package com.gntech.voting.Voting.adapter.out.repository.mapper;

import com.gntech.voting.Voting.adapter.out.repository.entity.VoteEntity;
import com.gntech.voting.Voting.application.core.domain.Vote;
import com.gntech.voting.Voting.config.mapper.MapperConfiguration;
import org.mapstruct.Mapper;

@Mapper(config = MapperConfiguration.class)
public interface VoteEntityMapper {

  VoteEntity voteToVoteEntity(Vote vote);

  Vote voteEntityToVote(VoteEntity voteEntity);

}
