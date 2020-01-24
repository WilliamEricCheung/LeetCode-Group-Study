package LeetCode.Heap;

import java.util.*;

public class HighFive_1086 {
    class Scores {
        Queue<Integer> top5;
        int sum;
        int count;

        public Scores() {
            top5 = new PriorityQueue();
            sum = 0;
            count = 0;
        }
    }

    class Solution {
        public int[][] highFive(int[][] items) {
            Map<Integer, Scores> map = new HashMap();
            for (int[] item : items) {
                if (!map.containsKey(item[0])) {
                    Scores socore = new Scores();
                    map.put(item[0], socore);
                }

                Scores score = map.get(item[0]);
                score.top5.add(item[1]);
                score.sum += item[1];
                score.count++;
                if (score.count > 5) {
                    score.sum -= score.top5.poll();
                    score.count--;
                }
            }

            int[][] ans = new int[map.size()][2];
            int index = 0;
            for (int key : map.keySet()) {
                ans[index][0] = key;
                ans[index][1] = (map.get(key).sum) / 5;
                index++;
            }

            Arrays.sort(ans, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[0] - o2[0];
                }
            });

            return ans;
        }
    }
}
