package org.example.todos;

import java.util.ArrayList;
import java.util.List;

public class MyNestedTodo {

  public enum TodoStatus {
    PENDING, DONE
  }

  List<MyTodoItem> todos;

  public MyTodoItem addTodoItem(String task, TodoStatus status) {
    MyTodoItem item = new MyTodoItem(task, status);
    todos.add(item);
    return item;
  }

  public MyNestedTodo() {
    this.todos = new ArrayList<>();
  }

  private void printTodos() {
    todos.forEach(todo -> printTodo(todo, 0));
  }

  private void printTodo(MyTodoItem todo, int depth) {
    System.out.println("\t".repeat(depth) + todo.toString());
    todo.getChildren().forEach(child -> printTodo(child, depth + 1));
  }

  public static void main(String[] args) {
    MyNestedTodo nestedTodo = new MyNestedTodo();
    MyTodoItem grains = nestedTodo.addTodoItem("Grains", TodoStatus.PENDING);
    grains.addChild(new MyTodoItem("Rice", TodoStatus.PENDING)
        .addChild(new MyTodoItem("HMT", TodoStatus.PENDING))
        .addChild(new MyTodoItem("Kollam", TodoStatus.PENDING))
        .addChild(new MyTodoItem("Basmati", TodoStatus.PENDING).addChild(
            new MyTodoItem("Ngp Basmati", TodoStatus.PENDING))));

    grains.addChild(new MyTodoItem("Wheat", TodoStatus.PENDING)
        .addChild(new MyTodoItem("MP", TodoStatus.PENDING))
        .addChild(new MyTodoItem("Jabalpur", TodoStatus.PENDING)));

    nestedTodo.addTodoItem("Vegetables", TodoStatus.PENDING);

    nestedTodo.printTodos();
  }


}
