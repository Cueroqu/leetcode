public class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> ret = new ArrayList<Integer>();
        ret.add(0);
        for (int i = 0; i < n; ++i) {
            int inc = 1 << i;
            for (int j = ret.size()-1; j >= 0; --j) {
                ret.add(ret.get(j)+inc);
            }
        }
        return ret;
    }
}