package src.implementation;

class Programmers_lv2_덧칠하기 {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        
        int now = 0;
        for(int i=0; i<section.length; i++) {
            if (section[i] <= now) continue;
            now = section[i] + m - 1;
            answer++;
        }
        
            
        return answer;
    }
}
