package com.gntech.voting.Voting.adapter.in.resource.exception.response;

public record ErrorMessageResponse(
    String message,
    String field
) {
}
