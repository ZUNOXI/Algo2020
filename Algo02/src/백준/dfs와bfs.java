package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class dfs와bfs {
	static int N, M, V;
	static ArrayList<Integer>list[];
	static boolean [] visited;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		/**
		 * dfs
		 * 노드로 받는다
		 * 노드별로 링크를 걸어 둔다
		 * dfs로 노드들을 읽어들인다.
		 * 
		 * bfs
		 * 큐를 써서 풀어본다
		 * 노드를 순서대로 큐에 넣어서 꺼낸다
		 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str);
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[N+1];
		
		for(int i = 1; i<N+1; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i = 0; i<M; i++) {
			str = br.readLine();
			st = new StringTokenizer(str);
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b);
			list[b].add(a);
		}
		
		// 노드 리스트들 오름차순으로 정렬하기
		for(int i = 1; i<N+1; i++) {
			Collections.sort(list[i]);
		}
		
		//dfs
		visited = new boolean[N+1];
		
		for(int i = 1; i<N+1; i++) {
			if(i==V) {
				visited[i]=true;
				dfs(i);
				break;
			}
		}
		
		System.out.println();
		
		//bfs
		bfs();
		
	}
	
	public static void dfs(int x) {
		System.out.print(x+" ");
		for(int i = 0; i<list[x].size(); i++) {
			int k = list[x].get(i);
			if(!visited[k]) {
				visited[k] = true;
				dfs(k);
			}
		}
	}
	
	public static void bfs() {
		visited = new boolean[N+1];
		Queue<Integer>queue = new LinkedList<>();
		for(int i = 1; i<N+1; i++) {
			if(i==V) {
				queue.add(i);
				visited[i] = true;
			}
		}
		
		while(!queue.isEmpty()) {
			int i = queue.poll();
			System.out.print(i+" ");
			for(int j = 0; j<list[i].size(); j++) {
				int k = list[i].get(j);
				if(!visited[k]) {
					visited[k] = true;
					queue.add(k);
				}
			}
		}
		
	}
}
