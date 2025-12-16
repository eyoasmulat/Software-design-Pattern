import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MementoDemo {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor();
        History history = new History();

        // initial state
        history.save(editor.createMemento());

        editor.append("Hello");
        history.save(editor.createMemento());

        editor.append(" World");
        history.save(editor.createMemento());

        editor.append("!");
        history.save(editor.createMemento());

        System.out.println("Current: " + editor.getContent()); // Hello World!

        // undo twice
        editor.restore(history.undo());
        System.out.println("After undo 1: " + editor.getContent()); // Hello World
        editor.restore(history.undo());
        System.out.println("After undo 2: " + editor.getContent()); // Hello

        // redo once
        editor.restore(history.redo());
        System.out.println("After redo 1: " + editor.getContent()); // Hello World
    }
}

// Originator
class TextEditor {
    private String content = "";

    public void setContent(String content) {
        this.content = content;
    }

    public void append(String text) {
        this.content += text;
    }

    public String getContent() {
        return content;
    }

    public Memento createMemento() {
        return new Memento(content);
    }

    public void restore(Memento m) {
        if (m != null) this.content = m.getState();
    }
}

// Memento
class Memento {
    private final String state;
    Memento(String state) { this.state = state; }
    String getState() { return state; }
}

// Caretaker with undo/redo stacks
class History {
    private final Stack<Memento> undo = new Stack<>();
    private final Stack<Memento> redo = new Stack<>();
    private final List<Memento> all = new ArrayList<>();

    void save(Memento m) {
        if (m == null) return;
        undo.push(m);
        all.add(m);
        redo.clear();
    }

    Memento undo() {
        if (undo.size() <= 1) return undo.peek(); // nothing to undo
        Memento current = undo.pop();
        redo.push(current);
        return undo.peek();
    }

    Memento redo() {
        if (redo.isEmpty()) return undo.peek();
        Memento next = redo.pop();
        undo.push(next);
        return next;
    }
}

