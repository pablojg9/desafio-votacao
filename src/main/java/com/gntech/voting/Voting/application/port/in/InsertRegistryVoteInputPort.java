package com.gntech.voting.Voting.application.port.in;

import com.gntech.voting.Voting.application.core.domain.Vote;

import java.util.UUID;

public interface InsertRegistryVoteInputPort {

  void insert(UUID agendaUUID, Vote vote);
}
