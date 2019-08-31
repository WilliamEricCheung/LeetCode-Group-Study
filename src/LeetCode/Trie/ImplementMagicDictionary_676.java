package LeetCode.Trie;

public class ImplementMagicDictionary_676 {
    class MagicDictionary {
        class TrieNode {
            TrieNode[] children;
            boolean end;
            public TrieNode() {
                children = new TrieNode[26];
                end = false;
            }
        }

        TrieNode root;

        /** Initialize your data structure here. */
        public MagicDictionary() {
            root = new TrieNode();
        }

        /** Build a dictionary through a list of words */
        public void buildDict(String[] dict) {
            for(String word: dict) {
                TrieNode cur = root;
                for(char letter: word.toCharArray()) {
                    int index = (int) (letter - 'a');
                    if(cur.children[index] == null)
                        cur.children[index] = new  TrieNode();
                    cur = cur.children[index];
                }
                cur.end = true;
            }
        }

        public boolean contains(char[] word) {
            TrieNode cur = root;
            for(char letter: word) {
                int index = (int) (letter - 'a');
                if(cur.children[index] == null)
                    return false;
                cur = cur.children[index];
            }
            return cur.end;
        }

        /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
        public boolean search(String word) {
            char[] S = word.toCharArray();
            for(int i = 0; i < S.length; i++) {
                char c = S[i];
                for(char tmp = 'a'; tmp < 'z'; tmp++) {
                    if (tmp == c)   continue;
                    S[i] = tmp;
                    if (contains(S))    return true;
                }
                S[i] = c;
            }
            return false;
        }
    }

    /**
     * Your MagicDictionary object will be instantiated and called as such:
     * MagicDictionary obj = new MagicDictionary();
     * obj.buildDict(dict);
     * boolean param_2 = obj.search(word);
     */

    public static void main(String[] args) {

    }
}
