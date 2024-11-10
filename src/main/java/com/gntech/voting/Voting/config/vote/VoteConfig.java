package com.gntech.voting.Voting.config.vote;

import com.gntech.voting.Voting.adapter.FindAgendaByIdAdapter;
import com.gntech.voting.Voting.adapter.FindByCpfAndAgendaAdapter;
import com.gntech.voting.Voting.adapter.InsertVoteAdapter;
import com.gntech.voting.Voting.application.core.usecase.InsertRegistryVoteUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class VoteConfig {

  @Bean
  public InsertRegistryVoteUseCase insertRegistryVoteUseCase(FindAgendaByIdAdapter findAgendaByIdAdapter,
                                                             InsertVoteAdapter insertVoteAdapter,
                                                             FindByCpfAndAgendaAdapter findByCpfAndAgendaAdapter) {
    return new InsertRegistryVoteUseCase(findAgendaByIdAdapter, insertVoteAdapter, findByCpfAndAgendaAdapter);
  }
}
