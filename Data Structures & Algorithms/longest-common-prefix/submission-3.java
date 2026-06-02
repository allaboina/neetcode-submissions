class TrieNode {
    Map<Character, TrieNode> children = new HashMap<>();
}

class Trie{
    TrieNode root = new TrieNode();

    void insert(String word) {
        TrieNode node = root;
        for (char c: word.toCharArray()) {
            node.children.putIfAbsent(c, new TrieNode());
            node = node.children.get(c);
        }
    }
    int lcp(String word, int prefixLen) {
        TrieNode node = root;
        int i = 0;
        while (i < Math.min(word.length(), prefixLen)){
            if(!node.children.containsKey(word.charAt(i))){
                return i;
            }
            node = node.children.get(word.charAt(i));
            i++;
        }
        return Math.min(word.length(), prefixLen);
    }
}


public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 1) {
            return strs[0];
        }

        int mini = 0;
        for(int i = 1; i < strs.length; i++){
            if(strs[mini].length() > strs[i].length()){
                mini = i;
            }
        }
        
        Trie trie = new Trie();
        trie.insert(strs[mini]);
        int prefixLen = strs[mini].length();

        for(int i = 0; i < strs.length; i++) {
            prefixLen = trie.lcp(strs[i], prefixLen);
        }
        return strs[0].substring(0, prefixLen);
    }
}