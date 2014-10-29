public class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> ret = new ArrayList<Integer>();
        ret.add(1);
        if (rowIndex == 0) return ret;
        int origin, so;
        for (int i = 1; i < rowIndex+1; ++i) {
            origin = 1;
            for (int j = 0; j < ret.size()-1; ++j) {
                so = ret.get(j+1);
                ret.set(j+1, origin + ret.get(j+1));
                origin = so;
            }
            ret.add(1);
        }
        return ret;
    }
}