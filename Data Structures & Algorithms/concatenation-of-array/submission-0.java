class Solution {
    public int[] getConcatenation(int[] nums) {
        int[] ans = new int[2*nums.length];
        int a=0;
        for (int i = 0; i<2; i++) {
            for (int num : nums) {
                ans[a++] = num;
            }
        }
        return ans;
    }
}