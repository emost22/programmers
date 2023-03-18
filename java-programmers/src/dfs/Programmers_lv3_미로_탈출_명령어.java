package src.dfs;

class Programmers_lv3_미로_탈출_명령어 {
    private int direct[][] = {{1,0},{0,-1},{0,1},{-1,0}};
    private String ans = "";

    private String getAddString(int d) {
        if (d == 0) {
            return "d";
        } else if (d == 1) {
            return "l";
        } else if (d == 2) {
            return "r";
        } else {
            return "u";
        }
    }

    private boolean dfs(int n, int m, int x, int y, int r, int c, int k, String sum) {
        if (x == r && y == c && k == 0) {
            ans = sum;
            return true;
        }

        if (k == 0) return false;
        if ((Math.abs(r-x) + Math.abs(c-y)) > k) return false;

        for (int d = 0; d < 4; d++) {
            int nx = x + direct[d][0];
            int ny = y + direct[d][1];

            if (nx <= 0 || ny <= 0 || nx > n || ny > m) continue;
            String next = sum + getAddString(d);
            boolean flag = dfs(n, m, nx, ny, r, c, k - 1, next);
            if (flag) return true;
        }

        return false;
    }

    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        String answer = "";

        if ((((Math.abs(r-x) + Math.abs(c-y)) + k) & 1) == 1) return "impossible";
        if (!dfs(n, m, x, y, r, c, k, "")) {
            ans = "impossible";
        }

        return answer = ans;
    }
}
