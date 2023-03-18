package src.dp;

public class Programmers_lv3_연속_펄스_부분_수열의_합 {
    public long solution(int[] sequence) {
        long answer = -100001;
        int N = sequence.length;

        long sum = 0L;
        long t = 1L;
        for (int i = 0; i < N; i++) {
            sum = Math.max(sum + (long)sequence[i] * t, sequence[i] * t);
            answer = Math.max(answer, sum);
            t = -t;
        }

        sum = 0L;
        t = -1L;
        for (int i = 0; i < N; i++) {
            sum = Math.max(sum + (long)sequence[i] * t, sequence[i] * t);
            answer = Math.max(answer, sum);
            t = -t;
        }

        return answer;
    }
}
