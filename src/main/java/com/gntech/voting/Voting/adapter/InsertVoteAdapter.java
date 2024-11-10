package com.gntech.voting.Voting.adapter;

import com.gntech.voting.Voting.adapter.out.repository.VoteRepository;
import com.gntech.voting.Voting.adapter.out.repository.entity.VoteEntity;
import com.gntech.voting.Voting.adapter.out.repository.mapper.VoteEntityMapper;
import com.gntech.voting.Voting.application.core.domain.Vote;
import com.gntech.voting.Voting.application.port.out.InsertVoteOutputPort;
import org.springframework.stereotype.Component;

@Component
public class InsertVoteAdapter implements InsertVoteOutputPort {

  private final VoteRepository voteRepository;
  private final VoteEntityMapper voteEntityMapper;

  public InsertVoteAdapter(final VoteRepository voteRepository, final VoteEntityMapper voteEntityMapper) {
    this.voteRepository = voteRepository;
    this.voteEntityMapper = voteEntityMapper;
  }

  @Override
  public Vote insert(Vote vote) {
    VoteEntity agendaEntity = voteEntityMapper.voteToVoteEntity(vote);
    voteRepository.save(agendaEntity);
    return voteEntityMapper.voteEntityToVote(agendaEntity);
  }
}
