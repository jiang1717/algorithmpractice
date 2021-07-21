package org.jiang.nowcoder;

import java.util.Stack;

public class NC76 {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        if(!stack2.isEmpty()){
            move();
        }
        stack2.push(node);
    }

    public int pop() {
        if(stack1.isEmpty()){
            move();
        }
        return stack1.pop();
    }

    public void move(){
        while(!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
    }
}
