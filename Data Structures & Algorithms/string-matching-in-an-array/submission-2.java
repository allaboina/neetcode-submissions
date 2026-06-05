class Solution {
    public List<String> stringMatching(String[] words) {
        List<String> res = new ArrayList<>();
        Arrays.sort(words, Comparator.comparingInt(String::length));

        for(int i = 0; i < words.length; i++) {
            for(int j = i+1; j < words.length; j++) {
                if(kmp(words[j],words[i]) != -1) {
                    res.add(words[i]);
                    break;
                }
            }
        }
        return res;
    }

    private int kmp(String word1, String word2) {
        int[] lps = new int[word2.length()];
        int prevLPS = 0, i = 1;

        while(i < word2.length()) {
            if (word2.charAt(i) == word2.charAt(prevLPS)) {
                lps[i] = prevLPS + 1;
                prevLPS++;
                i++;
            } else if (prevLPS == 0) {
                lps[i] = 0;
                i++;
            } else {
                prevLPS = lps[prevLPS - 1];
            }
        }

        i = 0;
        int j = 0;
        while(i < word1.length()) {
            if (word1.charAt(i) == word2.charAt(j)) {
                i++;
                j++;
            } else {
                if (j == 0) {
                    i++;
                } else {
                    j = lps[j - 1];
                }
            }

            if (j == word2.length()) {
                return i - word2.length();
            }
        }
        return -1;
    }
}