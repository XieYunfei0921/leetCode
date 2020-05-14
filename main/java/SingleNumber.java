public class SingleNumber {

	/**
	 * 位运算
	 * 1. 任何数与0异或都等于本身
	 * 2. 相等的两个数异或等于0
	 * @param nums
	 * @return
	 */
	static int singleNumber(int[] nums){
		int org=0;
		for (int x:nums) {
			org^=x;
		}
		return org;
	}

	public static void main(String[] args) {
		System.out.println(3 ^ 3);
	}
}
