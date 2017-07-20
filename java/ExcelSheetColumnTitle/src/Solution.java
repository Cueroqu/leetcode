/**
 * Created by zhun.qu on 6/6/17.
 */
public class Solution {
    public String convertToTitle(int n) {
        StringBuilder ans = new StringBuilder();
        for (;;) {
            n = n - 1;
            ans = ans.append((char)('A'+(n%26)));
            n /= 26;
            if (n == 0) break;
        }
        return ans.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().convertToTitle(28));
    }
}
