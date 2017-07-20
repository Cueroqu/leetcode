import java.util.LinkedHashMap;

public class Solution {
	public LinkedHashMap<Integer, String> map = new LinkedHashMap<Integer, String>();
	public int[] keyset = {1,4,5,9,10,40,50,90,100,400,500,900,1000};
	
	public void Initialize() {
		map.put(1, "I");
		map.put(4, "IV");
		map.put(5, "V");
		map.put(9, "IX");
		map.put(10, "X");
		map.put(40, "XL");
		map.put(50, "L");
		map.put(90, "XC");
		map.put(100, "C");
		map.put(400, "CD");
		map.put(500, "D");
		map.put(900, "CM");
		map.put(1000, "M");
	}
	
	public String intToRoman(int num) {
		StringBuilder ret = new StringBuilder();
		Initialize();
		for (int i = keyset.length - 1; i >= 0 && num > 0; --i) {
			while (keyset[i] <= num) {
				ret.append(map.get(keyset[i]));
				num -= keyset[i];
			}
		}
		return ret.toString();
	}
	
	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.intToRoman(3999));
	}
}
