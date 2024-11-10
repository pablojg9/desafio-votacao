package com.gntech.voting.Voting.adapter.in.resource;

import com.gntech.voting.Voting.adapter.in.resource.mapper.AgendaMapper;
import com.gntech.voting.Voting.adapter.in.resource.request.AgendaRequest;
import com.gntech.voting.Voting.adapter.in.resource.response.AgendaResponse;
import com.gntech.voting.Voting.application.core.domain.Agenda;
import com.gntech.voting.Voting.application.port.in.InsertAgendaInputPort;
import com.gntech.voting.Voting.application.port.in.InsertOpenSessionAgendaInputPort;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api/v1/agendas")
public class AgendaResource {

  private final InsertAgendaInputPort insertAgendaInputPort;

  private final InsertOpenSessionAgendaInputPort insertOpenSessionAgendaInputPort;

  private final AgendaMapper agendaMapper;

  public AgendaResource(final InsertAgendaInputPort insertAgendaInputPort,
                        final InsertOpenSessionAgendaInputPort insertOpenSessionAgendaInputPort,
                        final AgendaMapper agendaMapper) {
    this.insertAgendaInputPort = insertAgendaInputPort;
    this.insertOpenSessionAgendaInputPort = insertOpenSessionAgendaInputPort;
    this.agendaMapper = agendaMapper;
  }



  @PostMapping
  public CompletableFuture<ResponseEntity<AgendaResponse>> insert(@Valid @RequestBody final AgendaRequest agendaRequest) {
    Agenda agenda = insertAgendaInputPort.insert(agendaMapper.agendaRequestToAgenda(agendaRequest));
    return CompletableFuture.supplyAsync(() -> ResponseEntity.status(HttpStatus.CREATED).body(agendaMapper.agendaToAgendaResponse(agenda)));
  }

  @PostMapping("{agendaId}")
  public CompletableFuture<ResponseEntity<Void>> insert(@PathVariable final UUID agendaId,
                                                        @RequestParam(
                                                            value = "time",
                                                             required = false,
                                                            defaultValue = "1") final Integer timeMinutes) {
    insertOpenSessionAgendaInputPort.insert(agendaId, timeMinutes);
    return CompletableFuture.supplyAsync(() -> ResponseEntity.noContent().build());
  }
}
