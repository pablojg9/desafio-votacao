package com.gntech.voting.Voting.application.port.out;

import java.util.UUID;

public interface FindByCpfAndAgendaOutputPort {

  void find(String cpf, UUID agenda);

}
