import java.util.*;

public class ThreeSum {

	/*
	-4 -1 -1 0 1 2
	* */
	public static List<List<Integer>> threeSum(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> ans=new ArrayList<List<Integer>>();
		Set<String> set = new HashSet<String>();
		for (int i = 0; i < nums.length-2; i++) {
			int x=nums[i];
			int start= i+1;
			int stop=nums.length-1;
			while (start<stop){
				if(x+nums[start]+nums[stop]>0)
					stop--;
				else if(x+nums[start]+nums[stop]<0)
					start++;
				else if(x+nums[start]+nums[stop]==0){
					String tag=x+","+nums[start]+","+nums[stop];
					if(!set.contains(tag)){
						List<Integer> temp=new ArrayList<Integer>();
						temp.add(x);
						temp.add(nums[start]);
						temp.add(nums[stop]);
						ans.add(temp);
						set.add(x+","+nums[start]+","+nums[stop]);
					}
					start++;
				}
			}
		}
		return ans;
	}


	public static void main(String[] args) {
		int[] nums=new int[]{0,0,0,0};
		List<List<Integer>> list = threeSum(nums);
		for (List<Integer> t: list)
			System.out.println(t.toString());
	}
}
