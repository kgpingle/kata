package org.example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LeetCodeProblemsTest {

  @Test
  @DisplayName("should rank teams")
  public void shouldRankteams() {
    assertEquals("ABC",
        LeetCodeProblems.rankTeams(new String[]{"BCA", "CAB", "CBA", "ABC", "ACB", "BAC"}));
    assertEquals("ABC", LeetCodeProblems.rankTeams(new String[]{"ACB", "ABC", "ABC"}));
    assertEquals("XWYZ", LeetCodeProblems.rankTeams(new String[]{"WXYZ", "XYZW"}));
  }

}
