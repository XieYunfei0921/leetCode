import java.util.HashMap;
import java.util.Map;

public class SubArrayK{


	/**
	 * 前缀和方式
	 * @param nums
	 * @param k
	 * @return
	 */
	public static int subarraySum(int[] nums, int k) {
		// 求sum[i]的结果
		int cnt=0;
		int[] sum=new int[nums.length];
		sum[0]=nums[0];
		for (int i=1;i<nums.length;i++)
			sum[i]=sum[i-1]+nums[i];
		// 求start-end之间的和,等于sum[end]-sum[start],如果为k则加一
		for (int end = 0; end < sum.length; end++) {
			for (int start=0;start<=end;start++){
				if(sum[end]-sum[start]+nums[start]==k){
					cnt++;
				}
			}
		}
		return cnt;
	}

	/**
	 * 前缀和优化
	 * @param nums
	 * @param k
	 * @return
	 */
	public static int subarraySumOptimizer(int[] nums, int k){
		// 前缀和快查表,key代表前缀和,value代表前缀和个数
		Map<Integer, Integer> map = new HashMap<>();
		map.put(0,1);
		int sum=0,cnt=0;
		for (int num: nums) {
			sum+=num;
			/**
			 pre[i]=num[i]+pre[i-1]
			 如果i->j数组和为k
			 则pre[i]-pre[j-1]=k
			 所以
			 pre[j-1]=pre[i]-k
			 即快查表中存储匹配条件为pre[i]-k即sum-k
			 */
			if(map.containsKey(sum-k))
				cnt+=map.get(sum-k);
			map.put(sum,map.getOrDefault(sum,0)+1);
		}
		return cnt;
	}

	public static void main(String[] args) {
		int[] nums=new int[]{1,1,1};
		int k=2;
		int x=subarraySum(nums,k);
		int t=subarraySumOptimizer(nums,k);
//		System.out.println(x);
		System.out.println(t);
	}
}
