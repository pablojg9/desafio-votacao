package com.gntech.voting.Voting.adapter.in.resource.mapper;

import com.gntech.voting.Voting.adapter.in.resource.request.VoteRequest;
import com.gntech.voting.Voting.application.core.domain.Vote;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-11-10T01:21:28-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.11 (Oracle Corporation)"
)
@Component
public class VoteMapperImpl implements VoteMapper {

    @Override
    public VoteRequest voteToVoteRequest(Vote vote) {
        if ( vote == null ) {
            return null;
        }

        String cpf = null;
        String vote1 = null;

        cpf = vote.getCpf();
        vote1 = vote.getVote();

        VoteRequest voteRequest = new VoteRequest( cpf, vote1 );

        return voteRequest;
    }

    @Override
    public Vote voteRequestToVote(VoteRequest voteRequest) {
        if ( voteRequest == null ) {
            return null;
        }

        Vote vote = new Vote();

        vote.setVote( getCheckVote( voteRequest.vote() ) );
        vote.setCpf( voteRequest.cpf() );

        return vote;
    }
}
