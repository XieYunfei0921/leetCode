import java.util.Stack;

public class Palindrome {
	/**
	 * 判断是否为回文数
	 * @param x 输入数据
	 * @return
	 */
	public static boolean isPalindrome(int x) {
		String s=String.valueOf(x);
		int left=0;
		int right=s.length()-1;
		while (left<=right){
			if (s.charAt(left)!=s.charAt(right))
				return false;
			left++;
			right--;
		}
		return true;
	}

	public static boolean isPalindrome2(int x){
		if(x<0) return false;
		Stack<Integer> s=new Stack<>();
		int temp=x;
		while (x!=0){
			s.push(x%10);
			x/=10;
		}
		long res=0L,factor=1L;
		while (!s.empty()){
			res+=factor*s.pop();
			factor*=10;
		}
		return (int) res==temp;
	}

	public static void main(String[] args) {
		System.out.println(isPalindrome2(-121));
		System.out.println(isPalindrome2(121));
		System.out.println(isPalindrome2(10));
	}
}
