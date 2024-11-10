package com.gntech.voting.Voting.adapter.in.resource;

import com.gntech.voting.Voting.adapter.in.resource.mapper.AgendaMapper;
import com.gntech.voting.Voting.adapter.in.resource.request.AgendaRequest;
import com.gntech.voting.Voting.adapter.in.resource.response.AgendaResponse;
import com.gntech.voting.Voting.application.core.domain.Agenda;
import com.gntech.voting.Voting.application.port.in.InsertAgendaInputPort;
import com.gntech.voting.Voting.application.port.in.InsertOpenSessionAgendaInputPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.UUID;

import static com.gntech.voting.Voting.utlls.TestUtils.asJsonString;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.openMocks;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(AgendaResource.class)
class AgendaResourceTest {

  private static final UUID uuid = UUID.randomUUID();
  private static final Integer timeMinutes = 10;
  private static final String name = "Pauta1";

  @MockBean
  private InsertAgendaInputPort insertAgendaInputPort;

  @MockBean
  private InsertOpenSessionAgendaInputPort insertOpenSessionAgendaInputPort;

  @MockBean
  private AgendaMapper agendaMapper;

  @InjectMocks
  private AgendaResource agendaResource;

  @Autowired
  private MockMvc mockMvc;

  @BeforeEach
  public void setUp() {
    openMocks(this);
  }

  @Test
  @DisplayName("should request insert agenda resource")
  void shouldRequestInsertAgendaResource() throws Exception {
    AgendaRequest agendaRequest = new AgendaRequest(name);
    Agenda agenda = new Agenda();
    AgendaResponse agendaResponse = new AgendaResponse(uuid, name);

    given(agendaMapper.agendaRequestToAgenda(agendaRequest)).willReturn(agenda);
    given(insertAgendaInputPort.insert(agenda)).willReturn(agenda);
    given(agendaMapper.agendaToAgendaResponse(agenda)).willReturn(agendaResponse);

    mockMvc.perform(post("/api/v1/agendas")
            .contentType(MediaType.APPLICATION_JSON)
            .content(asJsonString(agendaRequest)))
        .andExpect(status().is2xxSuccessful());

    verify(agendaMapper).agendaRequestToAgenda(agendaRequest);
    verify(insertAgendaInputPort).insert(agenda);
    verify(agendaMapper).agendaToAgendaResponse(agenda);
  }

  @Test
  @DisplayName("should request insert open session success")
  void shouldRequestInsertOpenSessionAgendaWithSuccess() {
    try {
      doNothing().when(insertOpenSessionAgendaInputPort).insert(uuid, timeMinutes);
      mockMvc.perform(post("/api/v1/agendas/insert/{agendaId}", uuid, timeMinutes)
              .contentType(MediaType.APPLICATION_JSON))
          .andExpect(status().is2xxSuccessful());
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}