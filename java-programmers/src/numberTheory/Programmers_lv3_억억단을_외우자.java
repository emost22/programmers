package src.numberTheory;

class Programmers_lv3_억억단을_외우자 {
    private int maxCnt[][];
    private int cnt[];
    
    private void init(int e) {
        cnt = new int[e + 1];
        for (int i = 1; i <= e; i++) {
            int n = i;
            
            cnt[i] = 1;
            for (int j = 2; j * j <= n; j++) {
                int mul = 1;
                while (n % j == 0) {
                    mul++;
                    n /= j;
                }
                cnt[i] *= mul;
            }
            
            if (n != 1) cnt[i] *= 2;
        }
        
        maxCnt = new int[e + 1][2];
        int[] maxValue = new int[]{cnt[e], e};
        for (int i = e; i >= 1; i--) {
            if (cnt[i] >= maxValue[0]) {
                maxValue = new int[]{cnt[i], i};
            }
            
            maxCnt[i][0] = maxValue[0];
            maxCnt[i][1] = maxValue[1];
        }
    }
    
    public int[] solution(int e, int[] starts) {
        int[] answer = new int[starts.length];
        
        init(e);
        for (int i = 0; i < starts.length; i++) {
            answer[i] = maxCnt[starts[i]][1];
        }
        
        return answer;
    }
}
