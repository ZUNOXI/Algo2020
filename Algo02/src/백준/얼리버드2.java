package 백준;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 얼리버드2 {

   static class Solution {
      public String[] solution(String[] orders) {
         String[] answer = {};
         PriorityQueue<String> list = new PriorityQueue();
         HashMap<String, HashSet<String>> map = new HashMap<>();
         StringTokenizer stk;
         for (int i = 0; i < orders.length; i++) {
            stk = new StringTokenizer(orders[i]);
            String name = stk.nextToken();
            int stksize= stk.countTokens();
            if(map.containsKey(name)) {
               for (int j = 0; j < stksize; j++) {
                  map.get(name).add(stk.nextToken());
               }
            }else {
               map.put(name,new HashSet<>());
               for (int j = 0; j < stksize; j++) {
                  map.get(name).add(stk.nextToken());
               }
            }
         }
         int max=0;
         
         for(String key : map.keySet()) {
            max = max<map.get(key).size()?map.get(key).size():max;
         }
         
         for(String key : map.keySet()) {
            if(map.get(key).size()==max)
               list.add(key);
         }
         
         answer = new String[list.size()];
         for (int i = 0; i < answer.length; i++) {
            answer[i]=list.poll();
         }
         Arrays.sort(answer);
         return answer;
      }

      public static void main(String[] args) {
         Solution sol = new Solution();
         
      }
   }
}