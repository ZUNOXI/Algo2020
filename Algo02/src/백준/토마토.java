package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class 토마토 {
	static int N,M,Max;
	static int [][] arr;
	static boolean [][] visited;
	static Queue<Tomato>queue;	
	
	// 델타 함수 선언
	static int [] dr = {1,-1,0,0};
	static int [] dc = {0,0,1,-1};
	

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str);
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		Max = 0;
		
		// 1만큼씩 크게 배열을 선언
		arr = new int[N+2][M+2];
		
		// 토마토 위치 넣을 큐 선언
		queue = new LinkedList<>();
		
		// 방문배열 선언
		visited = new boolean[N+2][M+2];
		
		// for 문으로 맵을 입력받기
		for(int i = 1; i<N+1; i++) {
			str = br.readLine();
			st = new StringTokenizer(str);
			for(int j = 1; j<M+1; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j]==1) { // 토마토 위치 큐에 집어 넣기
					queue.add(new Tomato(i, j, 1));
					visited[i][j] = true;
				}
				else if(arr[i][j]==-1) { // -1 토마토가 없는 칸은 이미 방문한것으로 처리
					visited[i][j] = true;
				}
			}
		}
		
		// bfs 실행
		bfs();
		
		// check 함수 실행
		if(check()) {
			System.out.println(Max-1);
		}else {
			System.out.println(-1);
		}
	}
	
	// bfs 함수
	// 큐에서 뽑아 내고 델타함수를 사용하여 뽑아낸 숫자에서 1을 더하여 집어 넣는다.
	// 델타 함수를 사용할때는 방문하지 않은 곳만 큐에 집어 넣는다.
	public static void bfs() {
		while(!queue.isEmpty()) {
			Tomato t = queue.poll();
			int x = t.x;
			int y = t.y;
			int day = t.day;
			Max = Math.max(Max, day);
			
			visited[x][y] = true;  // 방문체크
			
			for(int i = 0; i<4; i++) {
				int nx = x+dr[i];
				int ny = y+dc[i];
				if(!visited[nx][ny]) {
					if(nx>0 && nx<N+1 && ny>0 && ny<M+1 && arr[nx][ny]==0) {
						visited[nx][ny] = true;
						queue.add(new Tomato(nx, ny, day+1));
					}
				}
			}
		}
	}
	
	// 방문 안한 배열이 있다면 모두 익지 못하는 상황이므로 false 리턴
	public static boolean check() {
		for(int x = 1; x<N+1; x++) {
			for(int y = 1; y<M+1; y++) {
				if(visited[x][y]==false) {
					return false;
				}
			}
		}
		return true;
	}	
}

// 토마토 클래스 선언
class Tomato{
	int x;
	int y;
	int day;
	public Tomato(int a, int b, int c) {
		this.x = a;
		this.y = b;
		this.day = c;
	}
}
