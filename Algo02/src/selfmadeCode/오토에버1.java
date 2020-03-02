package selfmadeCode;

public class 오토에버1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// test case 배열 선언
		int [] arr = {1,10,5,11,7};
		
		// solution 함수 실행
		System.out.println(solution(arr));
		
	}
		// t1 {1,2,3,4}   4
		// t2 {1,2,4,1,2,3}   5
		// t3 {4,3,2,1,4}	3
		// t4 {4,3,2,1}	0
		// t5 {1,10,5,11,7}	15
		

	public static int solution(int [] arr) {
		// 초기 값 설정
		int answer = -1;
		int N = arr.length;
		
		// 4중 포문으로 경우의 수 완탐
		for(int i = 0; i<N; i++) {
			for(int j = i+1; j<N; j++) {
				for(int k = i+1; k<N; k++) {
					if(j == k) {
						continue;
					}
					for(int l = j+1; l<N; l++) {
						if(l == k) {
							continue;
						}
						int sum1 = arr[k] - arr[i];
						if(sum1<0) sum1 = 0;
						int sum2 = arr[l] - arr[j];
						if(sum2<0) sum2 = 0;
						answer = Math.max(sum1+sum2, answer);
					}
				}
			}
		}
		if(answer<0)answer=0;
		return answer;
	}
}
