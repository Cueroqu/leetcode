import java.util.*;
public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        List<Integer> tmp = new ArrayList<Integer>();
        if (numRows == 0) return ret;
        tmp.add(1);
        ret.add(tmp);
        for (int i = 1; i < numRows; ++i) {
            tmp = new ArrayList<Integer>();
            tmp.add(1);
            for (int j = 0; j < ret.get(i-1).size()-1; ++j) {
                tmp.add(ret.get(i-1).get(j)+ret.get(i-1).get(j+1));
            }
            tmp.add(1);
            ret.add(tmp);
        }
        return ret;
    }
}