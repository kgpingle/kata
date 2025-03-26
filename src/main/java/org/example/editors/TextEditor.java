package org.example.editors;

import java.util.Stack;
import org.example.editors.TextEditor.Operation.Action;

public class TextEditor {

  static class Operation {

    enum Action {INSERT, DELETE}

    Action action;
    int index;
    String content;

    public Operation(Action action, int index, String content) {
      this.action = action;
      this.index = index;
      this.content = content;
    }
  }

  StringBuilder text;
  Stack<Operation> undoStack;
  Stack<Operation> redoStack;

  public TextEditor() {
    this.text = new StringBuilder();
    this.undoStack = new Stack<>();
    this.redoStack = new Stack<>();
  }

  public String getCurrentContent() {
    return text.toString();
  }

  public void insertAtEnd(String input) {
    // Always push operation happening currently in undo
    undoStack.push(new Operation(Action.INSERT, text.length(), input));
    text.append(input);
    redoStack.clear();
  }

  public void deleteAtEnd(int count) {
    if (text.length() < count) {
      count = text.length();
    }
    int removeIndex = text.length() - count;
    String textToRemove = text.substring(removeIndex);
    // Add entry in undo stack
    undoStack.push(new Operation(Action.DELETE, removeIndex, textToRemove));
    text.delete(removeIndex, text.length());
    redoStack.clear();
  }

  public void undo() {
    if (undoStack.isEmpty()) {
      return;
    }
    Operation lastOperation = undoStack.pop();
    redoStack.push(lastOperation);
    switch (lastOperation.action) {
      case INSERT -> {
        text.delete(lastOperation.index, lastOperation.index + lastOperation.content.length());
      } // Perform delete
      case DELETE -> {
        text.insert(lastOperation.index, lastOperation.content);
      } // Perform insert
      case null, default -> {
      } // skip don't do anything - TODO: ask product what we need to build here?
    }
  }

  public void redo() {
    if (redoStack.isEmpty()) {
      return;
    }
    Operation lastOperation = redoStack.pop();
    // TODO: undoStack.push(lastOperation);
    switch (lastOperation.action) {
      case INSERT -> {
        text.insert(lastOperation.index, lastOperation.content);
      } // apply same operation
      case DELETE -> {
        text.delete(lastOperation.index, lastOperation.index + lastOperation.content.length());
      } // apply same operation
    }
  }


  public static void main(String[] args) {
    TextEditor editor = new TextEditor();
    System.out.println("Current Text: " + editor.text.toString());
    editor.insertAtEnd("Hello");
    System.out.println("After insert: " + editor.text.toString()); // Hello
    editor.insertAtEnd("World");
    System.out.println("After insert: " + editor.text.toString()); // HelloWorld
    editor.deleteAtEnd(5);
    System.out.println("After Delete: " + editor.text.toString()); // Hello
    editor.undo();
    System.out.println("After Undo: " + editor.text.toString()); // HelloWorld
    editor.redo();
    System.out.println("After Redo: " + editor.text.toString()); // Hello
    editor.undo();
    System.out.println("After Undo: " + editor.text.toString());

//    editor.deleteAtEnd(5);
//    System.out.println("After Delete: " +  editor.text.toString()); //
//    editor.deleteAtEnd(5);
//    System.out.println("After Delete: " +  editor.text.toString()); //
  }


}
