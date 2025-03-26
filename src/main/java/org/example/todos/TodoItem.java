package org.example.todos;

import java.util.ArrayList;
import java.util.List;
import org.example.todos.NestedTodo.TodoStatus;

public class TodoItem {

  private final String item;
  private final List<TodoItem> children;
  private TodoStatus status;
  private TodoItem parent;

  public TodoItem(String item, TodoStatus status) {
    this.item = item;
    this.status = status;
    this.children = new ArrayList<>();
  }

  public TodoItem addChild(TodoItem todo) {
    todo.parent = this;
    this.children.add(todo);
    return this;
  }

  public List<TodoItem> getChildren() {
    return children;
  }

  public void setStatus(TodoStatus status) {
    this.status = status;
  }

  @Override
  public String toString() {
    return status + "\t" + item;
  }
}
