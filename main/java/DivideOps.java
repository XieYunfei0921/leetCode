public class DivideOps {

	public static int divide(int dividend, int divisor) {
		boolean positive=dividend-divisor<dividend ^ dividend>0?false:true;
		long ans=0;
		if (positive){
			while (!((dividend<divisor && divisor>0)
					||(dividend>divisor && divisor<0))){
				dividend-=divisor;
				ans++;
			}
		}else {
			while (!((-dividend<divisor && divisor>0)
					||(dividend<-divisor && divisor<0))){
				dividend+=divisor;
				ans--;
			}
		}
		if(ans>Integer.MAX_VALUE || ans<Integer.MIN_VALUE) return 0x7fffffff;
		return (int) ans;
	}

	public static void main(String[] args) {
		System.out.println(divide(-7,3));
	}
}
