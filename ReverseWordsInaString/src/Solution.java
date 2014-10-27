public class Solution {
    public String reverseWords(String s) {
    	return "";
    }
    
    public static void main(String[] args) {
    	String[] ss = "  a a a a    aa  ".trim().split("\\s+");
    	for (String s : ss) {
    		System.out.println("-" + s  + "-");
    	}
    }
}