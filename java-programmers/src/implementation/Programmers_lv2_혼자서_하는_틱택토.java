package src.implementation;

class Programmers_lv2_혼자서_하는_틱택토 {
    private int oCnt, xCnt;
    private int oWin, xWin;
    private int winChk[][];
    private final int N = 3;
    
    private void check(String[] board) {
        winChk = new int[N][N];
        for (int i = 0; i < N; i++) {
            if (board[i].charAt(0) != '.') {
                boolean flag = true;
                for (int j = 1; j < N; j++) {
                    if (board[i].charAt(j) != board[i].charAt(j - 1)) {
                        flag = false;
                        break;
                    }
                }

                if (flag) {
                    if (winChk[i][0] == 0 && winChk[i][1] == 0 && winChk[i][2] == 0) {
                        if (board[i].charAt(0) == 'O') {
                            oWin++;
                        } else {
                            xWin++;
                        }
                    }
                    winChk[i][0]++;
                    winChk[i][1]++;
                    winChk[i][2]++;
                }
            }
            
            if (board[0].charAt(i) != '.') {
                boolean flag = true;
                for (int j = 1; j < N; j++) {
                    if (board[j].charAt(i) != board[j - 1].charAt(i)) {
                        flag = false;
                        break;
                    }
                }

                if (flag) {
                    if (winChk[0][i] == 0 && winChk[1][i] == 0 && winChk[2][i] == 0) {
                        if (board[0].charAt(i) == 'O') {
                            oWin++;
                        } else {
                            xWin++;
                        }
                    }
                    winChk[0][i]++;
                    winChk[1][i]++;
                    winChk[2][i]++;
                }
            }
        }
        
        if (board[0].charAt(0) == board[1].charAt(1) && board[0].charAt(0) == board[2].charAt(2) && board[0].charAt(0) == board[0].charAt(2) && board[0].charAt(0) == board[2].charAt(0)) {
            if (winChk[0][0] == 0 && winChk[1][1] == 0 && winChk[2][2] == 0 && winChk[0][2] == 0 && winChk[2][0] == 0) {
                if (board[0].charAt(0) == 'O') oWin++;
                else if (board[0].charAt(0) == 'X') xWin++;
            }
        } else if (board[0].charAt(0) == board[1].charAt(1) && board[0].charAt(0) == board[2].charAt(2)) {
            if (winChk[0][0] == 0 && winChk[1][1] == 0 && winChk[2][2] == 0) {
                if (board[0].charAt(0) == 'O') oWin++;
                else if (board[0].charAt(0) == 'X') xWin++;
            }
        } else if (board[1].charAt(1) == board[0].charAt(2) && board[1].charAt(1) == board[2].charAt(0)) {
            if (winChk[1][1] == 0 && winChk[0][2] == 0 && winChk[2][0] == 0) {
                if (board[1].charAt(1) == 'O') oWin++;
                else if (board[1].charAt(1) == 'X') xWin++;
            }
        }
    }
    
    public int solution(String[] board) {
        int answer = -1;
        
        check(board);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i].charAt(j) == 'O') {
                    oCnt++;
                } else if (board[i].charAt(j) == 'X') {
                    xCnt++;
                }
            }
        }
        
        if (oWin > 1 || xWin > 1) {
            answer = 0;
        } else if (oWin > 0 && xWin > 0) {
            answer = 0;
        } else if (oWin == 1) {
            if (oCnt != xCnt + 1) answer = 0;
            else answer = 1;
        } else if (xWin == 1) {
            if (oCnt != xCnt) answer = 0;
            else answer = 1;
        } else {
            if (Math.abs(oCnt - xCnt) > 1) answer = 0;
            else if (xCnt > oCnt) answer = 0;
            else answer = 1;
        }
        
        return answer;
    }
}
