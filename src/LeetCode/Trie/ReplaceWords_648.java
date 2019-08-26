package LeetCode.Trie;

import java.util.List;
import java.util.ListIterator;

class ReplaceWords_648 {
    class Solution {
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
                if (p.is_word == true)
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
            String replacedWord = "";
            for (int i = 0; i < word.length(); i++) {
                if (p.is_word == true)
                    break;
                char letter = word.charAt(i);
                int index = (int) (letter - 'a');
                if (p.children[index] == null || i == word.length()) {
                    replacedWord = word;
                    break;
                }
                else {
                    replacedWord += letter;
                    p = p.children[index];
                }
            }
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

    static void main(String[] args) {

    }
}
