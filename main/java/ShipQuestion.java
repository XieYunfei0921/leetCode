/**
 * 这个问题没有描述，每天尽可能传送多的货物，不是贪心思路，需要重新思考
 */
public class ShipQuestion {

	public int shipWithinDays(int[] weights, int D) {
		int[] info = maxAndSum(weights);
		int low=info[0];
		int high=info[1];
		int res=501;
		while (low<high){
			// 计算每天的运送量
			int mid=(low+high)/2;
			// 使用贪心策略计算需要的天数
			int cnt=1;
			int start=0;
			int sum=0;
			while (start<weights.length){
				if(sum+weights[start]>mid){
					sum=weights[start];
					cnt++;
				}else {
					sum+=weights[start];
				}
				start++;
			}
			if(cnt>D) {
				if(low==mid) break;
				// 如果没有计算过可以进行下一次计算
				low=mid;
			} else if(cnt<D) {
				high=mid;
			}else if(cnt==D && mid<res){
				res=mid;
				high=mid;
			}
		}
		return res;
	}

	private int[] maxAndSum(int[] weights) {
		int[] res=new int[]{0,0};
		for (int i = 0; i <weights.length ; i++) {
			if(res[0]<weights[i])
				res[0]=weights[i];
			res[1]+=weights[i];
		}
		return res;
	}

	public static void main(String[] args) {
		int[] weights=new int[]{1,2,3,1,1};
		int D=4;
		ShipQuestion question = new ShipQuestion();
		int days = question.shipWithinDays(weights, D);
		System.out.println(days);
	}
}
