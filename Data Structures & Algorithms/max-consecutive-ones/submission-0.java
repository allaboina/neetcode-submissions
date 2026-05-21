class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int n = nums.length;
        int res = 0;

        for (int i = 0; i < n; i++) {
            int cnt = 0;
            for (int j = i; j < n; j++) {
                if (nums[j] == 0) break;
                cnt++;
            }
            res = Math.max(res, cnt);
        }
        return res;
    }
}