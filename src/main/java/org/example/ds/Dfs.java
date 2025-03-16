package org.example.ds;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class Dfs {

  // Aspect	DFS (Depth-First Search)
  // Time Complexity	O(V + E) (Adjacency List), O(N²) (Adjacency Matrix)
  // Space Complexity	O(V) (Recursive Stack for recursion-based DFS)
  // Best Use Case	When you need to go deep before wide (backtracking, finding paths, cycle detection, etc.)
  // Trade-offs	Can get stuck in infinite recursion if not handled properly. Not always best for shortest paths (BFS is better).

  // Why Use DFS for Cycle Detection?
  //DFS keeps track of the recursion stack, detecting back edges in directed graphs.

  //  Use Case	Approach
  //  Graph traversal (search)	Recursive or iterative DFS
  //  Tree traversal	Recursive DFS (Preorder, Inorder, Postorder)
  //  Cycle detection (directed graph)	Use DFS with recursion stack
  //  Pathfinding (all possible paths)	Use DFS with backtracking
  //  Topological sorting (DAG)	Use DFS with a stack


  public static void main(String[] args) {
    Map<Integer, List<Integer>> graph = new HashMap<>();
    graph.put(0, Arrays.asList(1, 2));
    graph.put(1, Arrays.asList(3, 4));
    graph.put(2, Arrays.asList(5));
    graph.put(3, Arrays.asList());
    graph.put(4, Arrays.asList(5));
    graph.put(5, Arrays.asList());

    List<Integer> visited = new ArrayList<>();

    System.out.println("DFS Traversal: recursive");
    recursive(graph, 0, visited);
    visited.forEach(a -> System.out.print(a + ","));

    System.out.println("DFS Traversal: iterative");
    iterative(graph, 0);
    visited.forEach(a -> System.out.print(a + ","));
  }

  /**
   * Time Complexity: O(V + E) Space Complexity: O(V) (due to recursion stack)
   */
  public static void recursive(Map<Integer, List<Integer>> graph, int node, List<Integer> visited) {
    if (visited.contains(node)) {
      return;
    }
    visited.add(node);
    for (int neighbour : graph.getOrDefault(node, List.of())) {
      recursive(graph, neighbour, visited);
    }
  }

  /**
   * Why Use Iterative? Avoids recursion stack overflow for deep graphs. Uses an explicit stack
   * instead.
   */
  public static void iterative(Map<Integer, List<Integer>> graph, int start) {
    Stack<Integer> stack = new Stack<>();
    List<Integer> visited = new ArrayList<>();
    stack.push(start);
    while (!stack.isEmpty()) {
      int node = stack.pop();
      if (!visited.contains(node)) {
        visited.add(node);
        for (int neighbour : graph.getOrDefault(node, List.of())) {
          stack.push(neighbour);
        }
      }
    }
  }
}
