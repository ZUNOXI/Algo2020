package selfmadeCode;

public class 오토에버복기1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int [] arr = {4,3,2,1};
		
		System.out.println(choice(arr));
		
	}
	
	// 시간복잡도 : n의 4제곱 
	
	// 4중 포문 시작
	public static int choice(int [] arr) {
		
		int len = arr.length;
		
		int max = -1;
		
		// i와 j가 사는 날, x와 y가 파는날
		for(int i = 0; i<len; i++) {
			for(int j = i+1; j<len; j++) {
				for(int x = i+1; x<len; x++) {
					if(x==j) {
						continue;
					}
					for(int y = x+1; y<len; y++) {
						if(j==y) {
							continue;
						}
						int sum1 = arr[x] - arr[i];
						int sum2 = arr[y] - arr[j];
						int total = sum1 + sum2;
						
						if(total>max) {
							max = total;
						}
					}
				}
			}
		}
		
		
		return max;
	}

}
