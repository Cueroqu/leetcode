public class Solution {
    public int lengthOfLastWord(String s) {
        int end, len, cnt;
        for (end = s.length()-1; end >= 0; --end)
            if (s.charAt(end) != ' ') break;
        if (end < 0) return 0;
        for (len = end, cnt = 0; len >= 0; --len, ++cnt) {
            if (s.charAt(len) == ' ') break;
        }
        return cnt;
    }
}