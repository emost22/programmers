package src.bfs;

import java.util.*;

class Programmers_lv2_미로_탈출 {
    private int sx, sy, ex, ey;
    private int N, M;
    private int direct[][] = {{0,1},{1,0},{0,-1},{-1,0}};
    private boolean visit[][][];
    
    private int bfs(String[] maps) {
        Deque<int[]> q = new ArrayDeque<>();
        visit = new boolean[N][M][2];
        
        q.add(new int[]{sx,sy,0});
        visit[sx][sy][0]=true;
        for (int t = 0; !q.isEmpty(); t++) {
            int qsize = q.size();
            while(qsize-- > 0) {
                int x = q.peek()[0];
                int y = q.peek()[1];
                int l = q.poll()[2];
                
                if (x == ex && y == ey && l == 1) {
                    return t;
                }
                
                for (int d = 0; d < 4; d++) {
                    int nx = x + direct[d][0];
                    int ny = y + direct[d][1];
                    int nl = l;
                    
                    if (nx<0 || ny<0 || nx>=N || ny>=M) continue;
                    if (l == 0 && maps[nx].charAt(ny) == 'L') nl = 1;
                    if (visit[nx][ny][nl] || maps[nx].charAt(ny) == 'X') continue;
                    
                    q.add(new int[]{nx,ny,nl});
                    visit[nx][ny][nl]=true;
                }
            }
        }
        
        return -1;
    }
    
    private void init(String[] maps) {
        N = maps.length;
        M = maps[0].length();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (maps[i].charAt(j) == 'S') {
                    sx = i;
                    sy = j;
                } else if (maps[i].charAt(j) == 'E') {
                    ex = i;
                    ey = j;
                }
            }
        }
    }
    
    public int solution(String[] maps) {
        int answer = 0;
        init(maps);
        
        return answer = bfs(maps);
    }
}
