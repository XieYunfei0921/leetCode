public class MultiMaxSubArray {

	public static int maxProduct(int[] nums) {
		int len=nums.length,ans=0x80000000;
		int[][] dp=new int[len][len];
		for (int i=0;i<nums.length;i++) dp[i][i]=nums[i];
		int start=0,end=1;
		while (start<end && start<len-1){
			dp[start][end]=dp[start][end-1]*nums[end];
			if (end<len-1)
				end++;
			else {
				start++;
				end=start+1;
			}
		}
		start=0;end=0;
		while (start<len){
			while (end>=start && end<len){
				if(dp[start][end]>ans){
					ans=dp[start][end];
				}
				end++;
			}
			start++;
			end=start;
		}
		return ans;
	}

	/**
	 * 空间复杂度优化版本
	 * @param nums
	 * @return
	 */
	public static int maxProduct2(int[] nums){
		int ans=0x80000000,maxVal=nums[0],minVal=nums[0];
		for (int i=1;i<nums.length;i++){
			int mx=maxVal,mn=minVal;
			maxVal=Math.max(mx*nums[i],Math.max(nums[i],mn*nums[i]));
			minVal=Math.min(mn*nums[i],Math.min(nums[i],mx*nums[i]));
			ans=Math.max(ans,maxVal);
		}
		return ans;
	}

	public static void main(String[] args) {
		int[] arr= new int[]{2,3,-2,4};
		int product = maxProduct2(arr);
		System.out.println(product);
	}
}
