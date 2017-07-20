import java.util.*;
public class Solution {
    public int evalRPN(String[] tokens) {
    	Stack<Integer> numbers = new Stack<Integer>();
    	Set<String> opes = new HashSet<String>();
    	opes.add("+");
    	opes.add("-");
    	opes.add("*");
    	opes.add("/");
    	Integer op1, op2;
    	for (int i = 0; i < tokens.length; ++i) {
    		if (opes.contains(tokens[i])) {
    			op2 = numbers.pop();
    			op1 = numbers.pop();
    			char c = tokens[i].charAt(0);
    			switch (c) {
    			case '+':
    				op1 += op2;
    				break;
    			case '-':
    				op1 -= op2;
    				break;
    			case '*':
    				op1 *= op2;
    				break;
    			case '/':
    				op1 /= op2;
    				break;
    			}
    			numbers.push(op1);
    		} else numbers.push(Integer.parseInt(tokens[i]));
    	}
    	return numbers.peek();
    }
    
    public static void main(String[] args) {
//    	String[] a = new String[]{"2", "1", "+", "3", "*"};
    	String[] a = new String[]{"4", "13", "5", "/", "+"};
    	System.out.println((new Solution()).evalRPN(a));
    }
}