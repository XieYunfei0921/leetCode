import java.util.Arrays;

public class RescueShip {

	public static int numRescueBoats(int[] people, int limit) {
		Arrays.sort(people);
		int start=0,end=people.length-1,ans=0;
		while (start<=end){
			if(people[start]+people[end]<=limit){
				start++;
				end--;
			}else {
				end--;
			}
			ans++;
		}
		return ans;
	}

	public static void main(String[] args) {

		int[] people=new int[]{3,5,3,4};
		int limit=5;
		System.out.println(numRescueBoats(people,limit));
	}
}
