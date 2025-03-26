package org.example.todos;

import java.util.ArrayList;
import java.util.List;
import org.example.todos.MyNestedTodo.TodoStatus;

public class MyTodoItem {

  String text;
  TodoStatus status;
  MyTodoItem parent;
  List<MyTodoItem> children;

  public MyTodoItem(String text, TodoStatus status) {
    this.text = text;
    this.status = status;
    this.children = new ArrayList<>();
  }

  public MyTodoItem addChild(MyTodoItem todo) {
    todo.parent = this;
    this.children.add(todo);
    return this;
  }

  public List<MyTodoItem> getChildren() {
    return children;
  }

  @Override
  public String toString() {
    return "\t" + text;
  }
}
