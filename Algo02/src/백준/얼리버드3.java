package 백준;

import java.util.Arrays;

public class 얼리버드3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	static int dr[] = {-1,0,1,0};
	static int dc[] = {0,1,0,-1};
	
	static int dfs(int[][] board,boolean[][] visited, int r,int c, int type,int N) {
		int val = 1;
		visited[r][c] = true;
		for(int k = 0 ; k < 4 ; k++) {
			int nr = r + dr[k];
			int nc = c + dc[k];
			if(nr < 0 || nr >= N || nc < 0 || nc >= N || visited[nr][nc]) continue;
			if(board[nr][nc] != type) continue;
			return dfs(board,visited,nr,nc,type,N) + 1;
		}
		return val;
	}
	
    public static int solution(int[][] board) {
    	int answer = 0;
    	int N = board.length;
    	boolean visited[][] = new boolean[N][N];
    	for(int i = 0 ; i < N ; i++) {
    		for(int j = 0 ; j < N ; j++) {
    			for(int k = 0 ; k < N ; k++) Arrays.fill(visited[k], false);
    			int val = dfs(board,visited,i,j,board[i][j],N);
    			answer = Math.max(answer, val);
    		}
    	}
    	if(answer == 1) return -1;
        return answer;
    }
}
