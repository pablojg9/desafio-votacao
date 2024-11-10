package com.gntech.voting.Voting.application.core.domain;

import java.util.UUID;

public class Vote {

  private UUID id;
  private String cpf;
  private String vote;
  private Agenda agenda;

  public Vote() {
  }

  public Vote(Agenda agenda, String vote, String cpf, UUID id) {
    this.agenda = agenda;
    this.vote = vote;
    this.cpf = cpf;
    this.id = id;
  }

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public String getCpf() {
    return cpf;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

  public String getVote() {
    return vote;
  }

  public void setVote(String vote) {
    this.vote = vote;
  }

  public Agenda getAgenda() {
    return agenda;
  }

  public void setAgenda(Agenda agenda) {
    this.agenda = agenda;
  }
}
