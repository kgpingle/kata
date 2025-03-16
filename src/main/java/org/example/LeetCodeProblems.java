package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class LeetCodeProblems {

  public static String rankTeams(String[] votes) {
    if (votes.length == 0) {
      return "";
    }
    int teams = votes[0].length();

    Map<Character, Integer> teamSymbolIndex = new HashMap<>();
    char[] symbols = votes[0].toCharArray();
    Arrays.sort(symbols);
    for (int i = 0; i < symbols.length; i++) {
      char teamSymbol = symbols[i];
      teamSymbolIndex.put(teamSymbol, i);
    }

    int[][] votesPerteam = new int[teams][teams];

    for (String vote : votes) {
      for (int i = 0; i < teams; i++) {
        int teamIndex = teamSymbolIndex.get(vote.charAt(i));
        votesPerteam[teamIndex][i]++;
      }
    }

    // sort
    List<Integer> teamIndices = new ArrayList<>(teamSymbolIndex.values().stream().toList());
    Collections.sort(teamIndices, (team1, team2) -> {
      for (int i = 0; i < teams; i++) {
        if (votesPerteam[team1][i] != votesPerteam[team2][i]) {
          return votesPerteam[team2][i] - votesPerteam[team1][i];
        }
      }
      return team1 - team2;
    });

    StringBuilder result = new StringBuilder();
    // build return
    for (int val : teamIndices) {
      Entry<Character, Integer> characterIntegerEntry = teamSymbolIndex.entrySet().stream()
          .filter(entry -> entry.getValue() == val).findFirst().orElseThrow();
      result.append(characterIntegerEntry.getKey());
    }

    return result.toString();
  }
}
