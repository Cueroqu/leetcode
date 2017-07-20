public class Solution {
    
    public boolean valid(String s) {
        int k = Integer.parseInt(s);
        if (k < 0 || k > 255) return false;
        if (s.charAt(0) == '0' && (k > 0 || s.length() > 1)) return false;
        return true;
    }
    
    public void restoreIpAddress(List<String> ret, String cur, String s, int left) {
        if (s.length() > left*3) return;
        if (s.length() < left) return;
        if (left == 1) {
            if (valid(s)) ret.add(cur+s);
            return;
        }
        if (s.charAt(0) == '0') {
            restoreIpAddress(ret, cur + "0" + ".", s.substring(1), left-1);
        } else {
            for (int i = 1; i <= 3 && i<= s.length(); ++i) {
                String tmp = s.substring(0, i);
                if (valid(tmp)) {
                    restoreIpAddress(ret, cur + tmp + ".", s.substring(i), left-1);
                }
            }
        }
    }
    
    public List<String> restoreIpAddresses(String s) {
        List<String> ret = new ArrayList<String>();
        restoreIpAddress(ret, "", s, 4);
        return ret;
    }
}