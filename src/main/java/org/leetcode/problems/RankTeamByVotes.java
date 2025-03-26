package org.leetcode.problems;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class RankTeamByVotes {

  public static String rankTeams(String[] votes) {
    if (votes.length == 0) {
      return "";
    }
    int numOfTeams = votes[0].length();
    Map<Character, Integer> teamIndex = new HashMap<>();
    char[] teams = votes[0].toCharArray();
    for (int i = 0; i < teams.length; i++) {
      teamIndex.put(teams[i], i);
    }

    int[][] votesPerTeam = new int[numOfTeams][numOfTeams];
    for (String vote : votes) {
      for (int i = 0; i < numOfTeams; i++) {
        votesPerTeam[teamIndex.get(vote.charAt(i))][i]++;
      }
    }

    List<Integer> teamIndices = new java.util.ArrayList<>(teamIndex.values().stream().toList());
    Collections.sort(teamIndices, (t1, t2) -> {
      for (int i = 0; i < numOfTeams; i++) {
        if (votesPerTeam[t1][i] != votesPerTeam[t2][i]) {
          return votesPerTeam[t2][i] - votesPerTeam[t1][i];
        }
      }
      return t1 - t2;
    });

    StringBuilder result = new StringBuilder();
    // build return
    for (int val : teamIndices) {
      Entry<Character, Integer> characterIntegerEntry = teamIndex.entrySet().stream()
          .filter(entry -> entry.getValue() == val).findFirst().orElseThrow();
      result.append(characterIntegerEntry.getKey());
    }

    return result.toString();

  }

}
