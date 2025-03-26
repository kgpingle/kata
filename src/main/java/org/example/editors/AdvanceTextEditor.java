package org.example.editors;

import java.util.Stack;
import org.example.editors.AdvanceTextEditor.Operation.Action;

public class AdvanceTextEditor {

  static class Operation {

    enum Action {INSERT, DELETE, CUT}

    private final int index;
    private final Action action;
    private final String content;

    public Operation(Action action, int index, String content) {
      this.index = index;
      this.action = action;
      this.content = content;
    }
  }

  StringBuilder text;
  String clipboard;
  Stack<Operation> undoStack;
  Stack<Operation> redoStack;

  public AdvanceTextEditor() {
    this.text = new StringBuilder();
    this.undoStack = new Stack<>();
    this.redoStack = new Stack<>();
  }

  public void cut(int startIndex, int endIndex) {
    if (text.length() < endIndex) {
      // incorrect cut - throw error?
      return;
    }
    String cutText = text.substring(startIndex, endIndex);
    clipboard = cutText;
    undoStack.push(new Operation(Action.CUT, startIndex, cutText));
    text.delete(startIndex, endIndex);
    redoStack.clear();
  }

  public void paste() {
    insertAtEnd(clipboard);
  }

  public void insertAtEnd(String input) {
    undoStack.push(new Operation(Action.INSERT, text.length(), input));
    text.append(input);
    redoStack.clear();
  }

  public void deleteAtEnd(int count) {
    if (text.length() < count) {
      count = text.length();
    }
    int removeFromIndex = text.length() - count;
    String removeText = text.substring(removeFromIndex);
    undoStack.push(new Operation(Action.DELETE, removeFromIndex, removeText));
    text.delete(removeFromIndex, text.length());
    redoStack.clear();
  }

  public void undo() {
    if (undoStack.isEmpty()) {
      return;
    }
    Operation lastOperation = undoStack.pop();
    redoStack.push(lastOperation);
    switch (lastOperation.action) {
      case INSERT -> text.delete(lastOperation.index,
          lastOperation.index + lastOperation.content.length());// Perform Delete
      case DELETE -> text.append(lastOperation.content); // Perform Insert
      case CUT -> text.insert(lastOperation.index, lastOperation.content); // Perform Insert
      case null, default -> {
      } // Skip and do nothing
    }
  }

  public void redo() {
    if (redoStack.isEmpty()) {
      return;
    }
    Operation lastOperation = redoStack.pop();
    undoStack.push(lastOperation);
    switch (lastOperation.action) {
      case INSERT -> text.append(lastOperation.content);// Perform Delete
      case DELETE, CUT -> text.delete(lastOperation.index,
          lastOperation.index + lastOperation.content.length()); // Perform Insert
      case null, default -> {
      } // Skip and do nothing
    }
  }

  public StringBuilder getText() {
    return text;
  }

  public static void main(String[] args) {
    AdvanceTextEditor editor = new AdvanceTextEditor();

    editor.insertAtEnd("Hello");
    System.out.println("After Insert: " + editor.getText()); // Hello

    editor.insertAtEnd(" World");
    System.out.println("After Insert: " + editor.getText()); // Hello World

    editor.deleteAtEnd(6);
    System.out.println("After Delete: " + editor.getText()); // Hello

    editor.undo();
    System.out.println("After Undo: " + editor.getText()); // Hello World

    editor.redo();
    System.out.println("After Redo: " + editor.getText()); // Hello

    editor.insertAtEnd(" my");
    System.out.println("After Insert: " + editor.getText()); // Hello my

    editor.insertAtEnd(" life");
    System.out.println("After Insert: " + editor.getText()); // Hello my life

    editor.redo(); // no op
    System.out.println("After redo: " + editor.getText()); // Hello my life

    editor.undo();
    System.out.println("After undo: " + editor.getText()); // Hello my

    editor.undo();
    System.out.println("After undo: " + editor.getText()); // Hello

    editor.undo();
    System.out.println("After undo: " + editor.getText()); // Hello World

    editor.redo();
    System.out.println("After redo: " + editor.getText()); // Hello

    editor.redo();
    System.out.println("After redo: " + editor.getText()); // Hello my

    editor.redo();
    System.out.println("After redo: " + editor.getText()); // Hello my life

    editor.cut(0, 5);
    System.out.println("After cut: " + editor.getText()); //  my life

    editor.insertAtEnd(" ");
    System.out.println("After Insert: " + editor.getText()); //  my life

    editor.paste();
    System.out.println("After paste: " + editor.getText()); //  my life Hello

    editor.undo();
    System.out.println("After undo: " + editor.getText()); //  my life

    editor.undo();
    System.out.println("After undo: " + editor.getText()); //  my life

    editor.undo();
    System.out.println("After undo: " + editor.getText()); //  Hello my life

    editor.redo();
    System.out.println("After redo: " + editor.getText()); //   my life
  }


}
