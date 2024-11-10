package com.gntech.voting.Voting.adapter.out.repository;

import com.gntech.voting.Voting.adapter.out.repository.entity.AgendaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AgendaRepository extends JpaRepository<AgendaEntity, UUID> {
}
