package LeetCode.BreadthFirstSearch;

import java.util.*;

public class WordLadderII_126 {
    class Solution {
        public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
            //build a Hashset for wordList
            Set<String> dict = new HashSet<>();
            for(String word: wordList)  dict.add(word);
            dict.remove(beginWord);

            //directed edges in the graph
            Map<String, List<String>> children = new HashMap<>();
            children.put(beginWord, new ArrayList<>());
            for (String word: dict) children.put(word, new ArrayList<>());

            List<List<String>> ans = new ArrayList<>();

            if(!dict.contains(endWord)) return ans;

            //Queue for bfs
            Queue<String> q = new ArrayDeque<>();
            q.offer(beginWord);

            //initialization
            int l = beginWord.length();
            boolean found = false;
            int steps = 0;

            //for every node in the queue, expand it
            //  if expanded node not in the dict, discard
            //  if in the dict, add it to the queue, record the edge
            //  if is endWord, break
            while (!q.isEmpty() && !found) {
                ++steps;

                //remove every node in this level to prevent loop
                for(String s: q)    dict.remove(s);

                for (int s = q.size(); s > 0; --s) {
                    String w = q.poll();
                    char[] chs = w.toCharArray();
                    for (int i = 0; i < l; i ++) {
                        char ch = chs[i];
                        for (char c = 'a'; c <= 'z'; c++) {
                            if (c == ch)    continue;
                            chs[i] = c;
                            String t = new String(chs);
                            if(!dict.contains(t))   continue;
                            if (t.equals(endWord)) {
                                found = true;
                                List<String> list = children.get(w);
                                list.add(t);
                            }
                            else if (!found) {
                                if (!q.contains(t))
                                    q.add(t);
                                List<String> list = children.get(w);
                                list.add(t);
                            } else  continue;

                        }
                        chs[i] = ch;
                    }
                }


            }

            //build solution: from beginWord, DFS
            if (found) {
                LinkedList<String> path = new LinkedList<>();
                path.add(beginWord);
                getpaths(beginWord, children, path, ans, beginWord, endWord);
            }

            return ans;
        }

        private void getpaths(String currWord, Map<String, List<String>> children, LinkedList<String> path,
                              List<List<String>> ans,
                              String beginWord, String endWord) {
            if (currWord.equals(endWord)) {
                ans.add(new ArrayList<String>(path));
                return;
            }
            List<String> ls = children.get(currWord);
            if(ls == null)  return;

            for(String s: ls) {
                path.add(s);
                getpaths(s, children, path, ans, beginWord, endWord);
                path.removeLast();
            }
        }
    }

    //initialize a list: Arrays.asList();
    public static void main(String[] args) {
        WordLadderII_126 cl = new WordLadderII_126();
        Solution sl = cl.new Solution();
        String beginWord = "red";
        String endWord = "tax";
        List<String> wordList = Arrays.asList("ted","tex","red","tax","tad","den","rex","pee");
        List<List<String>> ans = sl.findLadders(beginWord, endWord, wordList);
        System.out.println(ans);
    }
}
