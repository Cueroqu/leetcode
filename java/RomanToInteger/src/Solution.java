import java.util.LinkedHashMap;


public class Solution {
	public LinkedHashMap<String, Integer> map = new LinkedHashMap<String, Integer>();
	
	public void Initialize() {
		map.put("M", 1000);
		map.put("CM", 900);
		map.put("D", 500);
		map.put("CD", 400);
		map.put("C", 100);
		map.put("XC", 90);
		map.put("L", 50);
		map.put("XL", 40);
		map.put("X", 10);
		map.put("IX", 9);
		map.put("V", 5);
		map.put("IV", 4);
		map.put("I", 1);
	}
    public int romanToInt(String s) {
    	int index = 0, ret = 0;
    	Initialize();
    	outer:
    	for (String key : map.keySet()) {
    		if (key.length() + index - 1 >= s.length()) continue;
    		while (s.substring(index, index+key.length()).equals(key)) {
    			ret += map.get(key);
    			index += key.length();
    			if (index >= s.length()) break outer;
    			if (key.length() > 1) break;
    		}
    	}
    	return ret;
    }
    
    public static void main(String[] args) {
    	System.out.println("test".substring(1,2));
    	System.out.println((new Solution()).romanToInt("MDCXCV"));
    }
}
