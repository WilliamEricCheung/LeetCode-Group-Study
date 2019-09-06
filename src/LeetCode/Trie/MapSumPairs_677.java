package LeetCode.Trie;

import java.util.HashMap;

public class MapSumPairs_677 {

    //My implementation, using array to implement trie
    class MapSum {
        class TrieNode {
            TrieNode[] children;
            int valueSum;
            public TrieNode() {
                children = new TrieNode[26];
                valueSum = 0;
            }
        }

        TrieNode root;
        HashMap<String, Integer> map;

        /** Initialize your data structure here. */
        public MapSum() {
            root = new TrieNode();
            map = new HashMap<>();
        }

        public void insert(String key, int val) {
            TrieNode curr = root;
            if(map.containsKey(key)){
                int tmp = map.get(key);
                map.replace(key, val);
                val -= tmp;
            }
            else
                map.put(key, val);
            for (char letter : key.toCharArray()) {
                int index = (int) (letter - 'a');
                if (curr.children[index] == null)
                    curr.children[index] = new TrieNode();
                curr = curr.children[index];
                curr.valueSum += val;
            }
        }

        public int sum(String prefix) {
            TrieNode curr = root;
            for(char letter: prefix.toCharArray()) {
                int index = (int) (letter - 'a');
                if(curr.children[index] == null)
                    return 0;
                curr = curr.children[index];
            }
            return curr.valueSum;
        }

    }

    /**
     * Your MapSum object will be instantiated and called as such:
     * MapSum obj = new MapSum();
     * obj.insert(key,val);
     * int param_2 = obj.sum(prefix);
     */

}
