package src.bfs;

import java.util.*;

class Programmers_lv2_리코쳇_로봇 {
    private boolean visit[][][];
    private int direct[][] = {{0,1},{1,0},{0,-1},{-1,0}};
    private int N, M;
    private int sx, sy;
    
    private int[] getNext(String[] board, int x, int y, int d) {
        int nx=x;
        int ny=y;
        while(true) {
            nx+=direct[d][0];
            ny+=direct[d][1];

            if (nx<0 || ny<0 || nx>=N || ny>=M || board[nx].charAt(ny) == 'D') {
                nx-=direct[d][0];
                ny-=direct[d][1];
                return new int[]{nx, ny};
            }
        }
    }
    
    private int bfs(String[] board) {
        N = board.length;
        M = board[0].length();
        visit = new boolean[N][M][4];
        Deque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{sx, sy, 0});
        
        for(int t = 0; !q.isEmpty(); t++) {
            int qsize = q.size();
            while(qsize-- > 0) {
                int x = q.peek()[0];
                int y = q.poll()[1];
                
                if (board[x].charAt(y) == 'G') return t;
                
                for (int d=0; d<4; d++) {
                    int next[] = getNext(board, x, y, d);
                    
                    if (visit[next[0]][next[1]][d]) continue;
                    q.add(new int[]{next[0], next[1], d});
                    visit[next[0]][next[1]][d] = true;
                }
            }
        }
        
        return -1;
    }
    
    private void init(String[] board) {
        for(int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length(); j++) {
                if (board[i].charAt(j) == 'R') {
                    sx = i;
                    sy = j;
                }
            }
        }
    }
    
    public int solution(String[] board) {
        int answer = 0;
        
        init(board);
        answer = bfs(board);
        
        return answer;
    }
}
