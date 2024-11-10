package com.gntech.voting.Voting.application.core.domain;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class Agenda {

  private UUID id;
  private String name;
  private LocalDateTime startTime;
  private LocalDateTime endTime;
  private List<Vote> votes;

  public Agenda(UUID id, String name, LocalDateTime startTime, LocalDateTime endTime, List<Vote> votes) {
    this.id = id;
    this.name = name;
    this.startTime = startTime;
    this.endTime = endTime;
    this.votes = votes;
  }

  public Agenda() {
  }

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public LocalDateTime getStartTime() {
    return startTime;
  }

  public void setStartTime(LocalDateTime startTime) {
    this.startTime = startTime;
  }

  public LocalDateTime getEndTime() {
    return endTime;
  }

  public void setEndTime(LocalDateTime endTime) {
    this.endTime = endTime;
  }

  public List<Vote> getVotes() {
    return votes;
  }

  public void setVotes(List<Vote> votes) {
    this.votes = votes;
  }
}
