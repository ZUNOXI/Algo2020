package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N과M1 {
	static int N, M;
	static boolean[]visited;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s = br.readLine();
		StringTokenizer st = new StringTokenizer(s);
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		for(int i = 1; i<=N; i++) {
			visited = new boolean[N+1];
			String sen = "";
			perm(i,1,sen+i);
		}
		
	}
	
	public static void perm(int x, int cnt, String s) {
		visited[x] = true;
		if(cnt==M) {
			System.out.println(s);
			return;
		}
		for(int i = 1; i<N+1; i++) {
			if(!visited[i]) {
				perm(i,cnt+1,s+" "+i);
				visited[i]=false;
			}
		}
	}

}
