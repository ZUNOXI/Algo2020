package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N과M2 {
	static int N, M;
	static boolean [] visited;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		StringTokenizer st = new StringTokenizer(s);
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		for(int i = 1; i<N+1; i++) {
			visited = new boolean[N+1];
			String sen = ""+i;
			perm(i,1,sen);
		}
	}
	
	public static void perm(int x, int cnt, String s) {
		if(cnt == M) {
			System.out.println(s);
			return;
		}
		for(int i = x; i<N+1; i++) {
			if(!visited[i]) {
				perm(i+1,cnt+1,s+" "+i);
			}
		}
	}
}
