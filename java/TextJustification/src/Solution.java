import java.util.*;

public class Solution {
	public String wordsJustify(String[] words, int start, int tail, int length, int L) {
		int snum = tail - start - 1;
		int slen = ((snum == 0) ? 0 : (L-length) / snum);
		int extra = L - slen * snum - length;
		StringBuilder space = new StringBuilder();
		for (int i = 0; i < slen; ++i) space.append(' ');
		StringBuilder sb = new StringBuilder();
		for (int i = start; i < tail-1; ++i) {
			sb.append(words[i]);
			sb.append(space);
			if ((extra--) > 0) sb.append(' ');
		}
		sb.append(words[tail-1]);
		for (int i = 0; i < extra; ++i) sb.append(' ');
		return sb.toString();
	}
	
	public String tailJustify(String[] words, int start, int L) {
		StringBuilder ret = new StringBuilder();
		for (int i = start; i < words.length - 1; ++i) {
			ret.append(words[i] + " ");
		}
		ret.append(words[words.length-1]);
		while (ret.length() < L) ret.append(' ');
		return ret.toString();
	}
	
    public List<String> fullJustify(String[] words, int L) {
    	int curhead, curtail, endlength = 0, endhead = 0, endtail = 0, i, curlen;
    	List<String> ret = new ArrayList<String>();
    	if (L < 1) {
    		if (words.length > 0)
    			ret.add("");
    		return ret;
    	}
    	if (words.length < 1) return ret;
    	for (i = 0; i < words.length;) {
    		if (endlength+(endtail-endhead-1) <= L) {
    			for (; endtail < words.length && endlength+(endtail-endhead-1) <= L; ++endtail) {
    				endlength += words[endtail].length();
    			}
    			if (endtail == words.length && endlength+(endtail-endhead-1) <= L) {
    				ret.add(tailJustify(words, endhead, L));
    				return ret;
    			}
    		}
    		for (curlen = 0, curhead = i, curtail = i; curtail < words.length && curlen+(curtail-curhead-1) <= L; ++curtail) {
    			curlen += words[curtail].length();
    		}
    		--curtail;
    		curlen -= words[curtail].length();
    		endlength -= curlen;
    		i = endhead = curtail;
    		ret.add(wordsJustify(words, curhead, curtail, curlen, L));
    	}
    	return ret;
    }
    
    public List<String> fullJustify2(String[] words, int L) {
    	List<String> ret = new ArrayList<String>();
    	int cnt, j;
    	for (int i = 0, k = 0, l = 0; i < words.length; i += k) {
    		for (k = l = 0; i + k < words.length && l + words[i+k].length() <= L - k; ++k) {
    			l += words[i+k].length();
    		}
    		StringBuilder sb = new StringBuilder(words[i]);
    		for (j = 1; j < k; ++j) {
    			cnt = i + k >= words.length ? 1 : (L - l) / (k-1) + (j<=(L-l)%(k-1) ? 1 : 0);
    			while (cnt-- > 0) sb.append(' ');
    			sb.append(words[i+j]);
    		}
    		cnt = L - sb.length();
    		while (cnt-- > 0) sb.append(' ');
    		ret.add(sb.toString());
    	}
    	return ret;
    }
    
    public void print(List<String> ret) {
    	for (int i = 0; i < ret.size(); ++i) {
    		System.out.println(ret.get(i));
    	}
    }
    
    public static void main(String[] args) {
    	Solution s = new Solution();
    	String[] x = {"This", "is", "an", "example", "of", "text", "justification."};
    	s.print(s.fullJustify(x, 16));
    }
}
