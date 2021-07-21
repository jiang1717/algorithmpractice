package org.jiang.nowcoder;

import java.util.Stack;

public class NC52 {
    public boolean isValid (String s) {
        // write code here
        Stack<Character> left = new Stack<>();
        for(char c : s.toCharArray()){
            if(c == '(' || c == '[' || c == '{'){
                left.push(c);
            }else{
                if(!left.isEmpty() && left.peek() == right(c)){
                    left.pop();
                }else{
                    return false;
                }
            }

        }
        return left.isEmpty();
    }
    public char right (char c){
        if(c == ')'){
            return '(';
        }else if(c == ']'){
            return '[';
        }else{
            return '{';
        }
    }

}
