import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MinWindow {

	/*
	判断字符串S中是否包含所有的T的元素O(T)*O(M)复杂度太高,使用hash表存储T中的元素
	ADOBEC ODEBANC   ABC
	1. 基本思路
	如果子串s[i->j]包含T中的元素,那么这个子串可以向右滑动,否则i+1,移动到下一个子串
	如果T中的所有元素都找到之后,将串首个元素(T中的某个元素移除,i+1),继续滑动窗口,直到结束
	统计其中最小的窗口
	2. 基本操作单元的优化
	对于s[i->j]的子字符串,设置一个记录值为cnt,记录包含t中字符的数量(T是否有重复的)
	其中s[i->j+1]=s[i->j]+0/1,所以只需要判断s[j+1]是否为T中的元素即可,T中的元素存储在hash表中
	3. 起始条件
	s[0][0]=hashtable(s[0])==null?0:1
	 */
	public static String minWindow(String s, String t) {
		int len=s.length(),start=0,end=0,minlen=0x7fffffff;
		String ans = null;
		Map<Character,Integer> map=new HashMap();
		if(len<t.length()) return "";
		for (int i = 0; i <t.length() ; i++){
			char c=t.charAt(i);
			if(map.containsKey(c))
				map.put(c,map.get(c)+1);
			else
				map.put(c,1);
		}
		while (start<len){
			if(map.containsKey(s.charAt(start)))
				break;
			start++;
		}
		if(start>=len) return "";
		end=start;
		Map<Character,Integer> countMap=new HashMap<>();
		countMap.put(s.charAt(start),1);
		while (start<=end && end<len){
			int sign=mapEqual(map,countMap);
			if(sign==0){
				if(end-start<minlen){
					minlen=end-start;
					ans=s.substring(start,end+1);
				}
				countMap.put(s.charAt(start),countMap.get(s.charAt(start))-1);
				start++;
			}else if(sign==1 || sign==2){
				end++;
				if(end>len-1) break;
				int tmp=countMap.get(s.charAt(end))==null?0:countMap.get(s.charAt(end));
				countMap.put(s.charAt(end),tmp+1);
			}
		}
		return ans==null?"":ans;
	}

	static int mapEqual(Map<Character,Integer> ref,Map<Character,Integer> val){
		for (Character c:ref.keySet()) {
			if(val.get(c)==null) return 1;
			if(ref.get(c)>val.get(c)) return 2;
		}
		return 0;
	}

	public static void main(String[] args) {
		String s="ADOBECODEBANC",t="ABC";
		String s1 = minWindow(s, t);
		System.out.println(s1);
	}
}
