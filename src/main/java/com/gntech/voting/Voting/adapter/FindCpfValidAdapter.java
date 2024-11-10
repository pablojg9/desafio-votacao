package com.gntech.voting.Voting.adapter;

import com.gntech.voting.Voting.application.port.out.FindCpfValidOutputPort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.util.Random;

@Component
public class FindCpfValidAdapter implements FindCpfValidOutputPort {

  private final Random random = new Random();

  @Override
  public String find(String cpf) {
    if (random.nextBoolean()) return "ABLE_TO_VOTE";
    throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("CPF %s not found", cpf));
  }
}
