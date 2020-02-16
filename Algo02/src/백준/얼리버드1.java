package 백준;

public class 얼리버드1 {
	static boolean [] visited;
	static int [] arr = {1,10,5,11,7};

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution(arr));
		
	}
	// t1 {1,2,3,4}   4
	// t2 {1,2,4,1,2,3}   5
	// t3 {4,3,2,1,4}	3
	// t4 {4,3,2,1}	0
	// t5 {1,10,5,11,7}	15
	
	public static int solution(int[] prices) {
        int answer = 0; // answer를 0으로 해도 되지 않나??
        int N = prices.length;
        for(int i = 0 ; i < N; i++)
        {
           for(int j = i+1; j <N; j++ )
           {
              for(int k = i+1; k < N; k++)
              {
                 if(k == j) continue;
                 {
                    for(int l = j+1; l< N ;l++)
                     {
                        if(l == k) continue;
                        {
                           int sum1 = prices[k] -prices[i];
                           if(sum1 < 0) sum1 = 0;
                           int sum2 = prices[l] - prices[j];
                           if(sum2 < 0) sum2 = 0;
                           answer = Math.max(sum1+sum2, answer);
                        }
                     }
                 }
                 
              }
           }
        }
        if(answer < 0) answer = 0;
        return answer;
    }
}
