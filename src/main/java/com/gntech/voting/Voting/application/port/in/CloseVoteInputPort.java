package com.gntech.voting.Voting.application.port.in;

import com.gntech.voting.Voting.application.core.domain.Agenda;

public interface CloseVoteInputPort {

  void close(Agenda agenda);

}
