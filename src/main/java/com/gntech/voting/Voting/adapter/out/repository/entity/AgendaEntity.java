package com.gntech.voting.Voting.adapter.out.repository.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity(name = "agenda")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AgendaEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;
  private String name;
  private LocalDateTime startTime;
  private LocalDateTime endTime;

  @OneToMany(mappedBy = "agenda")
  private List<VoteEntity> votes;
}
