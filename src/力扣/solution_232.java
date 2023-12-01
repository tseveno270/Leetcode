import java.util.Stack;

public class solution_232 {
}
class MyQueue {
        private Stack<Integer> in;
        private Stack<Integer> out;

    public MyQueue() {
        in = new Stack<>();
        out = new Stack<>();

    }
    public void push(int x) {
        in.push(x);
    }

    public int pop(){
        if (out.isEmpty()){
            while (!in.isEmpty()){
                out.push(in.pop());
            }
        }
        return out.pop();
    }

    public int peek() {
        if (out.isEmpty()){
            while (!in.isEmpty()){
                out.push(in.pop());
            }
        }
        return out.peek();

    }

    public boolean empty() {
        return in.isEmpty()&&out.isEmpty();
    }
}
