public class Solution {
    public String addBinary(String a, String b) {
        int enda = a.length()-1, endb = b.length()-1, ra, rb;
        int t, f = 0, tf = 0;
        char tt;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Math.max(a.length(), b.length()); ++i, --enda, --endb) {
            ra = ((enda >= 0) ? (a.charAt(enda)-'0') : 0);
            rb = ((endb >= 0) ? (b.charAt(endb)-'0') : 0);
            tf = f;
            f = (ra & rb) | ((ra | rb) & f);
            t = ((ra ^ rb) + tf) % 2;
            tt = (char)(t+'0');
            sb.append(tt);
        }
        if (f > 0)
            sb.append('1');
        return sb.reverse().toString();
    }
    
    public static void main(String [] args) {
    	System.out.println((new Solution()).addBinary("11", "110"));
    }
}