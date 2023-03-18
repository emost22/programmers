package src.bfs;

import java.util.*;

class Programmers_lv3_숫자_타자_대회 {
    private int position[][] = {{3,1},{0,0},{0,1},{0,2},{1,0},{1,1},{1,2},{2,0},{2,1},{2,2}};
    private int dis[][][];
    private int N;
    private int left = 4;
    private int right = 6;
    
    private int bfs(String str) {
        Deque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{left, right});
        dis[0][left][right] = 0;

        for (int i = 0; i < N; i++) {
            int qsize = q.size();
            while (qsize-- > 0) {
                int l = q.peek()[0];
                int r = q.poll()[1];

                int num = str.charAt(i) - '0';
                int[] p = position[num];
                int[] lp = position[l];
                int[] rp = position[r];
                
                if (l == num || r == num) {
                    if (dis[i + 1][l][r] > dis[i][l][r] + 1) {
                        q.add(new int[]{l, r});
                        dis[i + 1][l][r] = dis[i][l][r] + 1;
                    }
                    continue;
                }

                int lx = Math.abs(p[0] - lp[0]);
                int ly = Math.abs(p[1] - lp[1]);

                int rx = Math.abs(p[0] - rp[0]);
                int ry = Math.abs(p[1] - rp[1]);

                int lDis = Math.min(lx, ly) * 3 + (Math.max(lx, ly) - Math.min(lx, ly)) * 2;
                int rDis = Math.min(rx, ry) * 3 + (Math.max(rx, ry) - Math.min(rx, ry)) * 2;
                
                if (dis[i + 1][num][r] > dis[i][l][r] + lDis) {
                    q.add(new int[]{num, r});
                    dis[i + 1][num][r] = dis[i][l][r] + lDis;
                }

                if (dis[i + 1][l][num] > dis[i][l][r] + rDis) {
                    q.add(new int[]{l, num});
                    dis[i + 1][l][num] = dis[i][l][r] + rDis;
                }
            }
        }

        int ret = Integer.MAX_VALUE;
        while (!q.isEmpty()) {
            int l = q.peek()[0];
            int r = q.poll()[1];

            ret = Math.min(ret, dis[N][l][r]);
        }

        return ret;
    }
    
    private void init() {
        for (int i = 0; i <= N; i++) {
            for (int j = 0; j < 10; j++) {
                Arrays.fill(dis[i][j], Integer.MAX_VALUE);
            }
        }
    }
    
    public int solution(String numbers) {
        int answer = 0;
        N = numbers.length();
        dis = new int[N + 1][10][10];
        init();
        
        return answer = bfs(numbers);
    }
}
