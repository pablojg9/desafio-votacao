package com.gntech.voting.Voting.adapter;

import com.gntech.voting.Voting.adapter.out.repository.VoteRepository;
import com.gntech.voting.Voting.adapter.out.repository.entity.VoteEntity;
import com.gntech.voting.Voting.application.core.exceptions.AgendaException;
import com.gntech.voting.Voting.application.port.out.FindByCpfAndAgendaOutputPort;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
public class FindByCpfAndAgendaAdapter implements FindByCpfAndAgendaOutputPort {

  private final VoteRepository voteRepository;


  public FindByCpfAndAgendaAdapter(VoteRepository voteRepository) {
    this.voteRepository = voteRepository;
  }

  @Override
  public void find(String cpf, UUID agenda) {
    Optional<VoteEntity> vote = voteRepository.findByCpfAndAgendaId(cpf, agenda);
    if (vote.isPresent()) throw new AgendaException("cpf already voted in the session");
  }
}
