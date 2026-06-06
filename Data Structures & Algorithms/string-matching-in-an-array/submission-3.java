class Solution {
    public List<String> stringMatching(String[] words) {
        List<String> res = new ArrayList<>();
        Arrays.sort(words, Comparator.comparingInt(String::length));

        for(int i = 0; i < words.length; i++) {
            for(int j = i+1; j < words.length; j++) {
                if(rabinKarp(words[j],words[i]) != -1) {
                    res.add(words[i]);
                    break;
                }
            }
        }
        return res;
    }

    private int rabinKarp(String word1, String word2) {
        int base1 = 31, mod1 = 768258391;
        int base2 = 37, mod2 = 685683731;
        int n = word1.length(), m = word2.length();

        long power1 = 1, power2 = 1;
        for(int k = 0; k < m; k++) {
            power1 = (power1 * base1) % mod1;
            power2 = (power2 * base2) % mod2;
        }

        long word1Hash1 = 0, word1Hash2 = 0;
        long word2Hash1 = 0, word2Hash2 = 0;

        for (int i =0; i < m; i++) {
            word1Hash1 = (word1Hash1 * base1 + word2.charAt(i)) % mod1;
            word1Hash2 = (word1Hash2 * base2 + word2.charAt(i)) % mod2;
            word2Hash1 = (word2Hash1 * base1 + word1.charAt(i)) % mod1;
            word2Hash2 = (word2Hash2 * base2 + word1.charAt(i)) % mod2;
        }

        for (int i = 0; i <= n - m; i++) {
            if (word2Hash1 == word1Hash1 && word2Hash2 == word1Hash2) {
                return i;
            }

            if (i + m < n) {
                word2Hash1 = (word2Hash1 * base1 - word1.charAt(i) * power1 + word1.charAt(i+m)) % mod1;
                word2Hash2 = (word2Hash2 * base2 - word1.charAt(i) * power2 + word1.charAt(i+m)) % mod2;

                if (word2Hash1 < 0) word2Hash1 += mod1;
                if(word2Hash2 < 0) word2Hash2 += mod2;
            }
        }

        return -1;
    }
}