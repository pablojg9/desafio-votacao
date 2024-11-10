package com.gntech.voting.Voting.adapter.in.resource;

import com.gntech.voting.Voting.adapter.in.resource.mapper.VoteMapper;
import com.gntech.voting.Voting.adapter.in.resource.request.VoteRequest;
import com.gntech.voting.Voting.application.port.in.InsertRegistryVoteInputPort;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api/v1/votes")
public class VoteResource {

  private final InsertRegistryVoteInputPort insertRegistryVoteInputPort;

  private final VoteMapper voteMapper;

  public VoteResource(InsertRegistryVoteInputPort insertRegistryVoteInputPort, VoteMapper voteMapper) {
    this.insertRegistryVoteInputPort = insertRegistryVoteInputPort;
    this.voteMapper = voteMapper;
  }

  @PostMapping("/vote/{agenda}")
  public CompletableFuture<ResponseEntity<Void>> insert(@PathVariable(name = "agenda") UUID agendaUUID, @Valid @RequestBody VoteRequest voteRequest) {
    insertRegistryVoteInputPort.insert(agendaUUID, voteMapper.voteRequestToVote(voteRequest));
    return CompletableFuture.supplyAsync(() -> ResponseEntity.status(HttpStatus.CREATED).build());
  }
}
