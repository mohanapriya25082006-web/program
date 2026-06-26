import java.util.ArrayList;

class Stack<T> {
    private ArrayList<T> list;

    public Stack() {
        list = new ArrayList<>();
    }

    public void push(T data) {
        list.add(data);
    }

    public T pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow! The stack is empty.");
            return null;
        }
        return list.remove(list.size() - 1);
    }

    public T peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
            return null;
        }
        return list.get(list.size() - 1);
    }

    public boolean isEmpty() {
        return list.size() == 0;
    }

    public int size() {
        return list.size();
    }
}

public class StackDemo {
    public static void main(String[] args) {

        Stack<Integer> stack = new Stack<>();

        System.out.println("Is stack empty? " + stack.isEmpty());

        System.out.println("\n--- Pushing Elements ---");
        stack.push(10);
        System.out.println("Pushed: 10");

        stack.push(20);
        System.out.println("Pushed: 20");

        stack.push(30);
        System.out.println("Pushed: 30");

        System.out.println("\nTop element (Peek): " + stack.peek());
        System.out.println("Current Stack Size: " + stack.size());

        System.out.println("\n--- Popping Elements ---");
        System.out.println("Popped: " + stack.pop());
        System.out.println("Popped: " + stack.pop());

        System.out.println("\nTop element after pops: " + stack.peek());
        System.out.println("Is stack empty now? " + stack.isEmpty());

        System.out.println("Popped: " + stack.pop());

        System.out.println("\n--- Testing Underflow ---");
        stack.pop();
    }
}
