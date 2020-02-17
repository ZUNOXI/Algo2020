package selfmadeCode;

public class 현대오토에버3 {
	
	// 델타 함수(상하좌우 순서)
	static int [] dr = {-1,1,0,0};
	static int [] dc = {0,0,-1,1};
	static int max;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [][] arr = {{4,2,3,2},{2,1,2,4},{1,2,3,1},{4,1,4,3}};
		System.out.println(solution(arr));
	}
	
	// t1 {{3,2,3,2},{2,1,1,2},{1,1,2,1},{4,1,1,1}}
	// t2 {{4,2,3,2},{2,1,2,4},{1,2,3,1},{4,1,4,3}}
	
	// dfs함수(visited,i,j,cnt)
	// 델타 함수 돌기
	// max 값 측정
	public static void dfs(boolean[][]visited,int x, int y, int cnt, int [][] arr,int N) {
		visited[x][y] = true;
		for(int i = 0; i<4; i++) {
			int nx = x+dr[i];
			int ny = y+dc[i];
			if(nx<0 || ny<0 || nx>=4 || ny>=4 || visited[nx][ny]) continue;
			if(arr[nx][ny]==N) {
				dfs(visited,nx,ny,cnt+1,arr,N);
			}
		}
		if(cnt>max) {
			max = cnt;
		}
	}
	
	
	// solution 함수
	// 2중 포문 + visitied 배열 새로 선언
	// dfs 돌리기
	public static int solution(int [][] arr) {
		max = -1;
		for(int x = 0; x<4; x++) {
			for(int y = 0; y<4; y++) {
				boolean [][] visited = new boolean [4][4];
				int N = arr[x][y];
				dfs(visited,x,y,1,arr,N);
			}
		}
			
		if(max==1) {
			return -1;
		}
		return max;
	}
}
