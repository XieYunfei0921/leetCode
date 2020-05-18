import java.util.HashSet;

public class MaxDinstinctSubString {

	public static int lengthOfLongestSubstring(String s) {
		int start=0,end;
		/**
		 * 最长子串区间满足:
		 * 在start和end之间无重复字符,且end+1和start-1都是重复字符(如果存在的话)
		 */
		HashSet<Character> set = new HashSet<>();
		int ans=0;
		while (start<s.length()){
			set.clear();
			end=start;
			while (end>=start && end<s.length()){
				if(!set.contains(s.charAt(end))){
					set.add(s.charAt(end));
					end++;
				}else
					break;
			}
			if(set.size()>ans)
				ans=set.size();
			start++;
		}
		return ans;
	}

	// 活动窗口法
	public static int lengthOfLongestSubstring2(String s) {
		return 0;
	}

	public static void main(String[] args) {
		String s="";
		int length = lengthOfLongestSubstring(s);
		System.out.println(length);
	}
}
