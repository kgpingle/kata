package org.leetcode.problems;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RankTeamByVotesTest {

  @Test
  @DisplayName("should rank teams")
  public void shouldRankteams() {
    assertEquals("ABC",
        RankTeamByVotes.rankTeams(new String[]{"BCA", "CAB", "CBA", "ABC", "ACB", "BAC"}));
    assertEquals("ABC", RankTeamByVotes.rankTeams(new String[]{"ACB", "ABC", "ABC"}));
    assertEquals("XWYZ", RankTeamByVotes.rankTeams(new String[]{"WXYZ", "XYZW"}));
  }
}