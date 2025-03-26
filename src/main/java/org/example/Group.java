package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Group {

  List<Group> children;
  String name;

  public Group(String name) {
    this.name = name;
    children = new ArrayList<>();
  }

  public Group addChildren(Group e) {
    this.children.add(e);
    return this;
  }

  @Override
  public boolean equals(Object o) {
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Group group = (Group) o;
    return Objects.equals(name,
        group.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name);
  }
}
