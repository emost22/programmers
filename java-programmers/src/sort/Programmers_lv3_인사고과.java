package src.sort;

import java.util.*;

class Programmers_lv3_인사고과 {
    public int solution(int[][] scores) {
        int answer = 0;
        int me[] = scores[0];
        
        Arrays.sort(scores, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            } else {
                return o2[0] - o1[0];
            }
        });
        
        int maxScore = scores[0][1];
        answer = 1;
        for (int i = 0; i < scores.length; i++) {
            if (scores[i][1] < maxScore) {
                if (scores[i][0] == me[0] && scores[i][1] == me[1]) {
                    return -1;
                }
            } else {
                if (scores[i][0] + scores[i][1] > me[0] + me[1]) answer++;
            }
            
            maxScore = Math.max(maxScore, scores[i][1]);
        }
        
        return answer;
    }
}
