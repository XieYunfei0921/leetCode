import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class FourNumber {

	public static List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> ans=new ArrayList<>();
		HashSet<String> set = new HashSet<>();
		Arrays.sort(nums);
		int start,end;
		for (int i = 0; i < nums.length; i++) {
			for (int j = i+1; j <nums.length ; j++) {
				start=j+1;end=nums.length-1;
				while (start<end){
					if (nums[i]+nums[j]+nums[start]+nums[end]>target)
						end--;
					else if(nums[i]+nums[j]+nums[start]+nums[end]<target)
						start++;
					else {
						if(!set.contains(nums[i]+","+nums[j]+","+nums[start]+","+nums[end])){
							ArrayList<Integer> list = new ArrayList<>();
							list.add(nums[i]);
							list.add(nums[j]);
							list.add(nums[start]);
							list.add(nums[end]);
							ans.add(list);
							set.add(nums[i]+","+nums[j]+","+nums[start]+","+nums[end]);
							System.out.println(list.toString());
						}
						start++;
					}
				}
			}
		}
		return ans;
	}


	public static void main(String[] args) {
		int[] arr=new int[]{-3,-2,-1,0,0,1,2,3,0};
		List<List<Integer>> ans = fourSum(arr,0);
	}
}
