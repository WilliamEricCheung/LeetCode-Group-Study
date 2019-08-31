package LeetCode.HashTable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ImplementMagicDict_676 {

    //implementing fuzzy match in java, original solution is in cpp;
    //using HashMap; HashMap.put(); HashMap.clear();
    //using StringBuilder to replace a specific character in an existing String.
    //  StringBuilder.setCharAt(index, character);
    class MagicDictionary {

        /** Initialize your data structure here. */
        public MagicDictionary() {
            magicDict.clear();
        }

        /** Build a dictionary through a list of words */
        public void buildDict(String[] dict) {
            for (String word: dict) {
                for (int i = 0; i < word.length(); i++) {
                    char v = word.charAt(i);
                    StringBuilder wordBuilder = new StringBuilder(word);
                    wordBuilder.setCharAt(i, '*');
                    String key = wordBuilder.toString();
                    HashSet<Character> S = magicDict.get(key);
                    if(S == null) {
                        S = new HashSet<>();
                    }
                    S.add(v);
                    magicDict.put(key, S);
                }
            }
        }

        /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
        public boolean search(String word) {
            for(int i = 0; i < word.length(); i++) {
                char v = word.charAt(i);
                StringBuilder sb = new StringBuilder(word);
                sb.setCharAt(i, '*');
                HashSet<Character> S = magicDict.get(sb.toString());
                if(S != null)
                    if((S.contains(v) == false) || S.size() >1)
                        return true;
            }
            return false;
        }

        HashMap<String, HashSet<Character>> magicDict = new HashMap<>();
    }

    //nested class
    //using Scanner class; initiating Scanner; Scanner.hasNext();
    //Converting Set to String using Set.toArray(new String[0]);
    public static void main(String[] args) {
        ImplementMagicDict_676 instance = new ImplementMagicDict_676();
        ImplementMagicDict_676.MagicDictionary obj = instance.new MagicDictionary();
        Scanner sc = new Scanner(System.in);
        Set<String> dictSet = new HashSet<>();

        for(int i = 0; i < 3; i++) {
        //while(sc.hasNext()) {
            dictSet.add(sc.nextLine());
        }
        String[] dict = dictSet.toArray(new String[0]);
        obj.buildDict(dict);
        System.out.println(obj.magicDict);

        String test = sc.nextLine();
        System.out.println(obj.search(test));
    }

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dict);
 * boolean param_2 = obj.search(word);
 */
}
