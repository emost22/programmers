package src.bfs;

import java.util.*;

class Programmers_lv2_무인도_여행 {
    private Deque<int[]> q = new ArrayDeque<>();
    private int direct[][] = {{0,1},{1,0},{0,-1},{-1,0}};
    private boolean visit[][];
    private int N, M;
    
    private int bfs(String[] maps, int sx, int sy) {
        q.add(new int[]{sx, sy});
        visit[sx][sy]=true;
        int ret = maps[sx].charAt(sy) - '0';
        while(!q.isEmpty()) {
            int x = q.peek()[0];
            int y = q.poll()[1];
            
            for (int d = 0; d < 4; d++) {
                int nx = x+direct[d][0];
                int ny = y+direct[d][1];
                
                if (nx<0 || ny<0 || nx>=N || ny>=M) continue;
                if (visit[nx][ny] || maps[nx].charAt(ny) == 'X') continue;
                
                q.add(new int[]{nx,ny});
                visit[nx][ny]=true;
                ret += (maps[nx].charAt(ny) - '0');
            }
        }
        
        return ret;
    }
    
    private int[] func(String[] maps) {
        ArrayList<Integer> list = new ArrayList<>();
        visit = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (maps[i].charAt(j) == 'X') continue;
                if (visit[i][j]) continue;
                list.add(bfs(maps, i, j));
            }
        }
        
        if (list.size() == 0) return new int[]{-1};
        
        Collections.sort(list);
        int[] ret = new int[list.size()];
        for(int i=0; i<list.size(); i++) {
            ret[i]=list.get(i);
        }
        
        return ret;
    }
    
    public int[] solution(String[] maps) {
        int[] answer = {};
        N = maps.length;
        M = maps[0].length();
        
        answer = func(maps);
        
        return answer;
    }
}
