package com.gntech.voting.Voting.application.port.out;

import com.gntech.voting.Voting.application.core.domain.Vote;

public interface InsertVoteOutputPort {

  Vote insert(Vote vote);

}
