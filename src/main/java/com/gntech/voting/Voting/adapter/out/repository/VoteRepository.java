package com.gntech.voting.Voting.adapter.out.repository;

import com.gntech.voting.Voting.adapter.out.repository.entity.VoteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface VoteRepository extends JpaRepository<VoteEntity, UUID> {

  Optional<VoteEntity> findByCpfAndAgendaId(String cpf, UUID agendaId);

}
