package com.gntech.voting.Voting.config.agenda;

import com.gntech.voting.Voting.adapter.InsertAgendaAdapter;
import com.gntech.voting.Voting.application.core.usecase.InsertAgendaUseCase;
import com.gntech.voting.Voting.application.core.usecase.InsertOpenSessionAgendaUseCase;
import com.gntech.voting.Voting.application.port.out.FindAgendaByIdOutputPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AgendaConfig {

  @Bean
  public InsertAgendaUseCase insertAgendaUseCase(InsertAgendaAdapter insertAgendaAdapter) {
    return new InsertAgendaUseCase(insertAgendaAdapter);
  }

  @Bean
  public InsertOpenSessionAgendaUseCase insertOpenSessionAgendaUseCase(FindAgendaByIdOutputPort findAgendaByIdOutputPort, InsertAgendaAdapter insertAgendaAdapter) {
    return new InsertOpenSessionAgendaUseCase(findAgendaByIdOutputPort, insertAgendaAdapter);
  }
}
