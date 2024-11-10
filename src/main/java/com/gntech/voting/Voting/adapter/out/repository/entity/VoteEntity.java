package com.gntech.voting.Voting.adapter.out.repository.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity(name = "vote")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VoteEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  private String cpf;
  private String vote;

  @ManyToOne
  @JoinColumn(name = "agenda_id")
  private AgendaEntity agenda;

}
