package com.gntech.voting.Voting.adapter.in.resource.request;

import org.hibernate.validator.constraints.br.CPF;

public record VoteRequest(

    @CPF(message = "UNABLE_TO_VOTE")
    String cpf,
    String vote
) {
}
