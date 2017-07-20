public class Solution {
	
	public StringBuilder Repeat(int a) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < a; ++i)
			sb.append('0');
		return sb;
	}
	
	public StringBuilder IntAdd(StringBuilder num1, StringBuilder num2) {
		StringBuilder sb = new StringBuilder();
		StringBuilder num0;
		if (num1.length() > num2.length()) {
			num0 = num2;
		} else {
			num0 = num1;
			num1 = num2;
		}
		num0 = num0.append(Repeat(num1.length()-num0.length()));
		int flag = 0;
		int tmp;
		for (int i = 0; i < num0.length(); ++i) {
			tmp = num0.charAt(i) + num1.charAt(i) - ('0' << 1) + flag;
			if (tmp > 9) {
				tmp %= 10;
				flag = 1;
			} else {
				flag = 0;
			}
			sb.append(tmp);
		}
		if (flag == 1) sb.append('1');
		return sb;
	}
	
    public String multiply(String num1, String num2) {
        StringBuilder sb = new StringBuilder(), one = new StringBuilder();
        StringBuilder n1 = new StringBuilder(num1), n2 = new StringBuilder(num2);
        n1.reverse(); n2.reverse();
        int i, j, tmp, tmp2, flag;
        for (i = 0; i < n1.length(); ++i) {
        	one.setLength(0);
        	tmp = n1.charAt(i) - '0';
        	flag = 0;
        	for (j = 0; j < n2.length(); ++j) {
        		tmp2 = (n2.charAt(j) - '0') * tmp + flag;
        		one.append(tmp2 % 10);
        		flag = tmp2 / 10;
        	}
        	if (flag > 0) one.append(flag);
        	sb = this.IntAdd(sb, this.Repeat(i).append(one));
        }
        String ret = sb.reverse().toString().replaceAll("^0+", "");
        if (ret.length() < 1) return "0";
        return ret;
        
    }
    
    public static void main(String[] args) {
    	Solution s = new Solution();
    	System.out.println(s.multiply("6124321890583", "0"));
    }
}