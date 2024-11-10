package com.gntech.voting.Voting.adapter.in.resource.response;

import java.util.UUID;

public record AgendaResponse(
    UUID uuid,
    String nameAgenda
) {
}
