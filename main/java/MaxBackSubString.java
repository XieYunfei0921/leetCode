public class MaxBackSubString<maxEnd, maxLen> {


	public static String longestPalindrome(String s) {
		if(s.equals("")) return "";
		boolean[][] dp=new boolean[s.length()][s.length()];
		int point=0;
		while (point<s.length()){
			int deta=0;
			while (point-deta>=0 && point+deta<s.length()){
				if (s.charAt(point-deta)==s.charAt(point+deta)){
					dp[point-deta][point+deta]=true;
					deta++;
				} else
					break;
			}
			deta=0;
			while (point-deta>=0 && point+1+deta<s.length()){
				if (s.charAt(point-deta)==s.charAt(point+1+deta)){
					dp[point-deta][point+1+deta]=true;
					deta++;
				} else
					break;
			}
			point++;
		}
		int start = 0,end=0,ans=0x80000000;
		for (int i = 0; i <s.length() ; i++) {
			for (int j = i; j <s.length() ; j++) {
				if(dp[i][j]==true && j-i>ans){
					ans=j-i;
					start=i;
					end=j;
				}
			}
		}
		return s.substring(start,end+1);
	}

	public static void main(String[] args) {
		String s="";
		String s1 = longestPalindrome(s);
		System.out.println(s1);
	}
}
