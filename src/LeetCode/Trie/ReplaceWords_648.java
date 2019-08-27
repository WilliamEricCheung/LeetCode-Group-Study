package LeetCode.Trie;

import java.util.List;
import java.util.ListIterator;

class ReplaceWords_648 {
    //original version, slow, 200+ms;
    class Solution1 {
        class TrieNode {
            public TrieNode() {
                children = new TrieNode[26];
                is_word = false;
            }
            public TrieNode[] children;
            public boolean is_word;
        }

        private TrieNode root;

        public void insert(String word) {
            TrieNode p = root;
            for (int i = 0; i < word.length(); i++){
                if (p.is_word == true)  //not necessary;
                    return;
                int index = (int) (word.charAt(i) - 'a');
                if(p.children[index] == null) {
                    p.children[index] = new TrieNode();
                }
                p = p.children[index];
            }
            p.is_word = true;
        }

        public String replace(String word) {
            TrieNode p = root;
            boolean hasPrefix = false;
            int endIndex = 0;
            for (int i = 0; i < word.length(); i++) {
                if (p.is_word == true) {
                    hasPrefix = true;
                    endIndex = i;
                    break;
                }
                char letter = word.charAt(i);
                int index = (int) (letter - 'a');
                if (p.children[index] == null || i == word.length()) {
                    hasPrefix = false;
                    break;
                }
                else {
                    p = p.children[index];
                }
            }
            String replacedWord = hasPrefix ? word.substring(0, endIndex) : word;
            return replacedWord;
        }

        public String replaceWords(List<String> dict, String sentence) {
            root = new TrieNode();
            ListIterator Itr = dict.listIterator();
            while (Itr.hasNext())
            {
                String word = (String) Itr.next();
                insert(word);
            }

            String[] sentenceArr = sentence.split("\\s+");
            for (int i = 0; i < sentenceArr.length; i++) {
                sentenceArr[i] = replace(sentenceArr[i]);
            }

            String output = "";
            for (int i =0 ; i < sentenceArr.length; i++) {
                output += sentenceArr[i];
                if (i != sentenceArr.length - 1)
                    output += " ";
            }
            return output;
        }
    }

    //improved version; official solution;
    //new api: String.toCharArray();
    //new class: StringBuilder; StringBuilder.append();StringBuilder.toString(); StringBuilder.length();
    class Solution2{
        class TrieNode {
            TrieNode[] children;
            String word;
            TrieNode() {
                children = new TrieNode[26];
                word = null;
            }
        }
        public String replaceWords(List<String> dict, String sentence){
            TrieNode root = new TrieNode();
            for(String word: dict) {
                TrieNode cur = root;
                for(char letter: word.toCharArray()){
                    int index = (int)(letter - 'a');
                    if (cur.children[index] == null)
                        cur.children[index] = new TrieNode();
                    cur = cur.children[index];
                }
                cur.word = word;
            }

            StringBuilder ans = new StringBuilder();

            for(String word: sentence.split("\\s+")) {
                TrieNode cur = root;
                for(char letter: word.toCharArray()) {
                    int index = (int) (letter - 'a');
                    if (cur.children[index] == null || cur.word != null)
                        break;
                    cur = cur.children[index];
                }
                if(ans.length()>0)   ans.append(" ");
                ans.append(cur.word == null ? word : cur.word);
            }
            return ans.toString();
        }
    }
}
