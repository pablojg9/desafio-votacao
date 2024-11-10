package com.gntech.voting.Voting.adapter.in.resource.request;

import jakarta.validation.constraints.NotBlank;

public record AgendaRequest(

    @NotBlank
    String name
) {
}
