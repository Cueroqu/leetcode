public class Solution {
    int[][][] record;
    
    public boolean isInterLeave(String s1, String s2, String s3, int ss1, int ss2, int ss3) {
        if (record[ss1][ss2][ss3] != 0) return (record[ss1][ss2][ss3] == 2);
        if (s1.length() + s2.length() != s3.length()) return false;
        if (ss1 < s1.length() && s1.charAt(ss1) == s3.charAt(ss3) && isInterLeave(s1,s2,s3,ss1+1,ss2,ss3+1)) {
            record[ss1][ss2][ss3] = 2;
        } else if (ss2 < s2.length() && s2.charAt(ss2) == s3.charAt(ss3) && isInterLeave(s1,s2,s3,ss1,ss2+1,ss3+1)) {
            record[ss1][ss2][ss3] = 2;
        } else if (ss1 == s1.length() && ss2 == s2.length() && ss3 == s3.length()) {
            return true;
        } else record[ss1][ss2][ss3] = 1;
        return (record[ss1][ss2][ss3] == 2);
    }
    
    public boolean isInterleave(String s1, String s2, String s3) {
        record = new int[s1.length()+1][s2.length()+1][s3.length()+1];
        return isInterLeave(s1, s2, s3, 0, 0, 0);
    }
}