package src.queue;

import java.util.*;

class Programmers_lv2_호텔_대실 {
    private ArrayList<int[]> list = new ArrayList<>();
    
    private int func() {
        int ret = 0;
        PriorityQueue<Integer> q = new PriorityQueue<>((o1, o2) -> o1 - o2);
        for (int[] t: list) {
            while (!q.isEmpty() && q.peek() <= t[0]) q.poll();
            
            q.add(t[1] + 10);
            ret = Math.max(ret, q.size());
        }
        
        return ret;
    }
    
    private void init(String[][] book_time) {
        for (String[] bt: book_time) {
            String[] sTime = bt[0].split(":");
            String[] eTime = bt[1].split(":");
            
            int st = Integer.parseInt(sTime[0]) * 60 + Integer.parseInt(sTime[1]);
            int et = Integer.parseInt(eTime[0]) * 60 + Integer.parseInt(eTime[1]);
            list.add(new int[]{st, et});
        }
        
        Collections.sort(list, (o1, o2) -> o1[0]-o2[0]);
    }
    
    public int solution(String[][] book_time) {
        int answer = 0;
        
        init(book_time);
        answer = func();
        
        return answer;
    }
}
