
    public class Stack {
        private int[] stackArray;
        private int top;
        private int maxSize;
    
        // Constructor to initialize stack
        public Stack(int size) {
            maxSize = size;
            stackArray = new int[maxSize];
            top = -1;
        }
    
        // Push an element onto the stack
        public void push(int value) {
            if (isFull()) {
                System.out.println("Stack is full. Cannot push value.");
                return;
            }
            stackArray[++top] = value;
        }
    
        // Pop an element from the stack
        public int pop() {
            if (isEmpty()) {
                System.out.println("Stack is empty. Cannot pop value.");
                return -1; // return a default value, you might want to handle this differently
            }
            return stackArray[top--];
        }
    
        // Peek at the top element of the stack
        public int peek() {
            if (isEmpty()) {
                System.out.println("Stack is empty. No top element.");
                return -1; // return a default value, you might want to handle this differently
            }
            return stackArray[top];
        }
    
        // Check if the stack is empty
        public boolean isEmpty() {
            return (top == -1);
        }
    
        // Check if the stack is full
        public boolean isFull() {
            return (top == maxSize - 1);
        }
    
        public static void main(String[] args) {
            Stack stack = new Stack(5);
    
            stack.push(10);
            stack.push(20);
            stack.push(30);
            stack.push(40);
            stack.push(50);
    
            System.out.println("Top element is: " + stack.peek());
    
            while (!stack.isEmpty()) {
                System.out.println("Popped element: " + stack.pop());
            }
    
            stack.pop(); // Attempt to pop from an empty stack
        }
    }

