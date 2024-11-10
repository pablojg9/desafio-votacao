package com.gntech.voting.Voting.application.core.domain;

public class VoteResult {

  private Integer votesYes;
  private Integer votesNo;

  public VoteResult(Integer votesYes, Integer votesNo) {
    this.votesYes = votesYes;
    this.votesNo = votesNo;
  }

  public VoteResult() {
  }

  public Integer getVotesYes() {
    return votesYes;
  }

  public void setVotesYes(Integer votesYes) {
    this.votesYes = votesYes;
  }

  public Integer getVotesNo() {
    return votesNo;
  }

  public void setVotesNo(Integer votesNo) {
    this.votesNo = votesNo;
  }
}
