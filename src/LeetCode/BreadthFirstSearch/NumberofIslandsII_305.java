package LeetCode.BreadthFirstSearch;

import java.util.*;

public class NumberofIslandsII_305 {
    class Solution {
        public List<Integer> numIslands2(int m, int n, int[][] positions) {
            List<Integer> ans = new ArrayList<>();
            HashMap<Integer, Integer> land2id = new HashMap<Integer, Integer>();
            int num_islands = 0;
            int island_id = 0;

            for (int[] pos : positions) {
                int r = pos[0], c = pos[1];
                if (land2id.containsKey(r * n + c)) {
                    ans.add(num_islands);
                    continue;
                }
                Set<Integer> overlap = new HashSet<Integer>();
                if (r - 1 >= 0 && land2id.containsKey((r - 1) * n + c))  {
                    overlap.add(land2id.get((r - 1) * n + c));
                }

                if (r + 1 < m && land2id.containsKey((r + 1) * n + c)) {
                    overlap.add(land2id.get((r + 1) * n + c));
                }

                if (c - 1 >= 0 && land2id.containsKey(r * n + c - 1)) {
                    overlap.add(land2id.get(r * n + c - 1));
                }

                if (c + 1 < n && land2id.containsKey(r * n + c + 1)) {
                    overlap.add(land2id.get(r * n + c + 1));
                }

                if (overlap.isEmpty()) {
                    ++ num_islands;
                    land2id.put(r * n + c, island_id++);
                } else if (overlap.size() == 1) {
                    land2id.put(r * n + c, overlap.iterator().next());
                } else {
                    int root_id = overlap.iterator().next();
                    for (Map.Entry<Integer, Integer> entry : land2id.entrySet()) {
                        int k = entry.getKey();
                        int id = entry.getValue();
                        if (overlap.contains(id)) {
                            land2id.put(k, root_id);
                        }
                    }

                    land2id.put(r * n + c, root_id);
                    num_islands -= (overlap.size() - 1);
                }
                ans.add(num_islands);
            }
            return ans;
        }
    }
}
