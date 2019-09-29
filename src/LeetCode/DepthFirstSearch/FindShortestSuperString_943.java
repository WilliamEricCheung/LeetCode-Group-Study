package LeetCode.DepthFirstSearch;

import java.util.Arrays;

import static java.lang.Integer.MAX_VALUE;
import static java.lang.Integer.min;

public class FindShortestSuperString_943 {
    class Solutionv1 {
        int[] best_path;
        int best_len;
        int[] curr_path;
        int curr_len;
        int[][] cost;
        boolean used[];

        public String shortestSuperstring(String[] A) {
            best_path = new int[A.length];
            best_len = MAX_VALUE;
            cost = new int[A.length][A.length];

            //construct cost
            for(int i = 0; i < A.length; i++) {
                for(int j = 0; j < A.length; j++) {
                    if(i == j ) continue;
                    cost[i][j] = A[j].length();
                    int overlap = 0;
                    for(int k = 0; k < ((A[i].length() < A[j].length()) ? A[i].length() : A[j].length()); k++) {
//                        System.out.println(A[i].substring(A[i].length() - k));
//                        System.out.println(A[j].substring(0, k));
                        if(A[i].substring(A[i].length() - k).equals(A[j].substring(0, k))) {
                            overlap = k;
                        }
                    }
                    cost[i][j] -= overlap;
                }
            }

            //construct used[]
            used = new boolean[A.length];
            for(int i = 0; i < A.length; i++)
                used[i] = false;

            //dfs
            curr_len = 0;
            curr_path = new int[A.length];
            dfs(A, 0);

            String ans = new String();
            ans += A[best_path[0]];
            for(int i = 1; i < best_path.length; i++) {
                int j = i - 1;
                ans += A[best_path[i]].substring(A[best_path[i]].length() - cost[best_path[j]][best_path[i]]);
            }
            return ans;
        }

        public void dfs(String[] A,int d) {
            if(d == A.length) {
                best_len = curr_len;
                best_path = Arrays.copyOf(curr_path, curr_path.length);
                return;
            }

            //for every string in A, append it to current string;
            //if curr_len + cost > best_len, continue;
            //then dfs(A, d+1)
            for(int i = 0; i < A.length; i++) {
                if(used[i]) continue;
                if(d == 0) {
                    curr_len = A[i].length();
                }
                else {
                    int j = curr_path[d-1];
                    if(curr_len + cost[j][i] >= best_len)    continue;
                    curr_len += cost[j][i];
                }
                curr_path[d] = i;
                used[i] = true;
                dfs(A, d+1);
                used[i] = false;
                curr_len -= (d == 0) ? A[i].length() : cost[curr_path[d-1]][i];
            }
        }
    }

    //copy of array: Array.clone();
    class Solution {
        private int n;
        private int[][] g;
        private String[] a;
        private int best_len;
        private int[] path;
        private int[] best_path;

        public void dfs(int d, int used, int cur_len) {
            if (cur_len >= best_len)    return;
            if (d == n) {
                best_len = cur_len;
                best_path = path.clone();
                return;
            }

            for(int i = 0; i < n; i++) {
                if((used & (1 << i) )!= 0)    continue;
                path[d] = i;
                dfs(d+1,
                        used | (1 << i),
                        d == 0 ? a[i].length() : cur_len + g[path[d - 1]][i]);
            }
        }

        public String shortestSuperstring(String[] A) {
            n = A.length;
            g = new int [n][n];
            a = A;
            for (int i = 0; i < n; ++i)
                for(int j = 0; j < n; ++j) {
                    g[i][j] = A[j].length();
                    for(int k = 1; k <= Math.min(A[i].length(), A[j].length()); ++k)
                        if (A[i].substring(A[i].length()-k).equals(A[j].substring(0, k)))
                            g[i][j] = A[i].length() - k;
                }
            path = new int[n];
                best_len = MAX_VALUE;

                dfs(0, 0, 0);

                String ans = A[best_path[0]];

                for(int k = 1; k < n; k++) {
                    int i = best_path[k - 1];
                    int j = best_path[k];
                    ans += A[j].substring(A[j].length() - g[i][j]);
                }
                return ans;
        }
    }

    public static void main(String[] args) {
        FindShortestSuperString_943 cls = new FindShortestSuperString_943();
        Solution slt = cls.new Solution();
//        String[] A = {"catg","ctaagt","gcta","ttca","atgcatc"};
        String[] A = {"sssv","svq","dskss","sksss"};
        String ans = slt.shortestSuperstring(A);
        System.out.println(ans);
        System.out.println(ans.length());
    }
}
