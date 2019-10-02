package LeetCode.BreadthFirstSearch;

import java.util.*;

public class WordLadder_127 {

    //BFS, time: 68.63%, space: 75.91%
    //Implementing Queue: ArrayDeque. api: offer(), isEmty(), poll()
    //Using queue to store pass nodes
    //Queue: first in first out
    class Solution_BFS {
        public int ladderLength(String beginWord, String endWord, List<String> wordList) {
            Set<String> dict = new HashSet<>();
            for(String word: wordList)  dict.add(word);

            if(!dict.contains(endWord)) return 0;

            Queue<String> q = new ArrayDeque<>();
            q.offer(beginWord);

            int l = beginWord.length();
            int steps = 0;

            while(!q.isEmpty()) {
                ++steps;
                for (int s = q.size(); s > 0; --s) {
                    String w = q.poll();
                    char[] chs = w.toCharArray();
                    for (int i = 0; i < l; i++) {   //change every letter in the word with 25 other letters
                        char ch = chs[i];
                        for (char c = 'a'; c <= 'z'; c++) {
                            if (c == ch)    continue;
                            chs[i] = c;
                            String t = new String(chs);
                            if (t.equals(endWord))  return steps + 1;
                            if(!dict.contains(t))   continue;   //if the changed word is not in the dict, discard it
                            dict.remove(t); //prevent circle
                            q.offer(t); //if in the dict, store it in the queue
                        }
                        chs[i] = ch;
                    }
                }
            }

            return 0;

        }
    }

    //Bidirectional BFS: time 94.61%, space 97.81%
    class Solution {
        public int ladderLength(String beginWord, String endWord, List<String> wordList) {
            Set<String> dict = new HashSet<>();
            for(String word: wordList)  dict.add(word);

            if(!dict.contains(endWord)) return 0;

            Set<String> q1 = new HashSet<>();
            Set<String> q2 = new HashSet<>();

            //difference between ArrayDeque.add() and offer(): if fail, add() will
            //  throw an Exception while offer() will return false;
            //  Apparently this is not an ArrayQue;
            q1.add(beginWord);
            q2.add(endWord);

            int l = beginWord.length();
            int steps = 0;

            while(!q1.isEmpty() && !q2.isEmpty()) {

                ++steps;

                //balance: if q1 is larger than q2, swap
                if(q1.size() > q2.size()) {
                    Set<String> temp= q1;
                    q1 = q2;
                    q2 = temp;
                }

                //nodes in this level;
                Set<String> q = new HashSet<>();

                for (String w: q1) {
                    char[] chs = w.toCharArray();
                    for (int i = 0; i < l; i++) {
                        char ch = chs[i];
                        for (char c = 'a'; c <= 'z'; c++) {
                            if (c == ch)    continue;
                            chs[i] = c;
                            String t = new String(chs);
                            if (q2.contains(t)) return steps + 1;   //if two trees meet at the same node, then
                                //there exists path from beginWord to endWord;
                            if(!dict.contains(t))   continue;
                            q.add(t);
                            dict.remove(t);
                        }
                        chs[i] = ch;
                    }
                }

                q1 = q; //discard previous nodes, replace with this level nodes;
            }

            return 0;
        }
    }

//    public static void main(String[] args) {
//        WordLadder_127 cl = new WordLadder_127();
//        Solution sl = cl.new Solution();
//        String beginWord = "hit";
//        String endWord = "cog";
//        //ArrayList initialization: new ArrayList<Type>(List.of(...));
//        List<String> wordList = new ArrayList<String>(List.of("hot","dot","dog","lot","log","cog"));
//        int ans = sl.ladderLength(beginWord, endWord, wordList);
//        System.out.println(ans);
//    }

}
