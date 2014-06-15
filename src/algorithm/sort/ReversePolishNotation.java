package algorithm.sort;

import java.util.Stack;

public class ReversePolishNotation {
		    public int evalRPN(String[] tokens) {
	    if (tokens == null || tokens.length == 0) return 0;
	            Stack<Integer> stack = new Stack<Integer>();
	            int n = tokens.length;
	            for (int i=0; i<n; i++) {
	                if (tokens[i].equals("+")) {
	                    int a = stack.pop();
	                    int b = stack.pop();
	                    stack.push(a+b);
	                } else if (tokens[i].equals("-")) {
	                    int a = stack.pop();
	                    int b = stack.pop();
	                    stack.push(b-a);
	                } else if (tokens[i].equals("*")) {
	                    int a = stack.pop();
	                    int b = stack.pop();
	                    stack.push(a*b);
	                } else if (tokens[i].equals("/")) {
	                    int a = stack.pop();
	                    int b = stack.pop();
	                    stack.push(b/a);
	                } else {
	                    stack.push(Integer.parseInt(tokens[i]));
	                }
	            }
	            return stack.pop();
	}    
	    }


