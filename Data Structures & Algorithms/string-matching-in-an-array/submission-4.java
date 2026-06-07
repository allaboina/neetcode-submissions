class Solution {
    public List<String> stringMatching(String[] words) {
        List<String> res = new ArrayList<>();
        Arrays.sort(words, Comparator.comparingInt(String::length));

        for(int i = 0; i < words.length; i++) {
            for(int j = i+1; j < words.length; j++) {
                if(zAlgorithm(words[j],words[i]) != -1) {
                    res.add(words[i]);
                    break;
                }
            }
        }
        return res;
    }

    private int zAlgorithm(String word1, String word2) {
        String s = word2 + "$" + word1;
        int n = s.length();
        int[] z = new int[n];
        int l = 0, r = 0;

        for (int i = 1; i < n; i ++) {
            if (i <= r) {
                z[i] = Math.min(r - i + 1, z[i-l]);
            }
            while (i + z[i] < n && s.charAt(z[i]) == s.charAt(i + z[i])) {
                z[i]++;
            }
            if(i + z[i] - 1 > r) {
                l = i;
                r = i + z[i] - 1;
            }
        }

        for (int i = word2.length() + 1; i < n; i++) {
            if(z[i] == word2.length()) {
                return i - word2.length() - 1;
            }
        }
        return -1;
    }
}