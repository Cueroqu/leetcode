import java.util.*;

public class Solution {
	
	public String join(Stack<String> stack) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < stack.size(); ++i) {
			sb.append("/" + stack.get(i));
		}
		if (sb.length() < 1) sb.append('/');
		return sb.toString();
	}
	
    public String simplifyPath(String path) {
    	Stack<String> stack = new Stack<String>();
    	String tmp;
    	if (path.length() < 2) return "/";
    	for (int i = 1, j = 1; i < path.length() && j < path.length(); ) {
    		while (j < path.length() && path.charAt(j) != '/') ++j;
    		tmp = path.substring(i, j);
    		if (tmp.equals("..")) {
    			if (stack.size() > 0)
    				stack.pop();
    		}
    		else if (tmp.length() > 0 && !tmp.equals(".")) {
    			stack.push(tmp);
    		}
    		i = j = j+1;
    	}
    	return join(stack);
    }
    
    public static void main(String[] args) {
    	String[] paths = "/.".split("/+");
    	System.out.println(":" + paths.length + ":");
    	for (int i = 0; i < paths.length; ++i) {
    		System.out.println(":" + paths[i] + ":");
    	}
    	System.out.println((new Solution()).simplifyPath("/.../abc"));
    }
}