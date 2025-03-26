package org.example.todos;


import java.util.ArrayList;
import java.util.List;

public class NestedTodo {

  public enum TodoStatus {
    PENDING,
    DONE
  }

  private final List<TodoItem> todos;

  public NestedTodo() {
    this.todos = new ArrayList<>();
  }

  public TodoItem addTodoItem(String task, TodoStatus status) {
    TodoItem item = new TodoItem(task, status);
    todos.add(item);
    return item;
  }

  public void printTodos() {
    todos.forEach(todo -> printTodo(todo, 0));
  }

  private void printTodo(TodoItem todo, int depth) {
    System.out.println("\t".repeat(depth) + todo);
    todo.getChildren().forEach(child -> printTodo(child, depth + 1));
  }

  public static void main(String[] args) {
    NestedTodo nestedTodo = new NestedTodo();

    TodoItem grains = nestedTodo.addTodoItem("Grains", TodoStatus.PENDING);
    grains.addChild(new TodoItem("Rice", TodoStatus.PENDING)
        .addChild(new TodoItem("HMT", TodoStatus.PENDING))
        .addChild(new TodoItem("Kollam", TodoStatus.PENDING))
        .addChild(new TodoItem("Basmati", TodoStatus.PENDING)));

    grains.addChild(new TodoItem("Wheat", TodoStatus.PENDING)
        .addChild(new TodoItem("MP", TodoStatus.PENDING))
        .addChild(new TodoItem("Jabalpur", TodoStatus.PENDING)));

    nestedTodo.addTodoItem("Vegetables", TodoStatus.PENDING);
    nestedTodo.printTodos();

  }

}
