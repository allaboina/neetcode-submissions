class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int res = 0, cnt = 0;
        for (int i:nums) {
            if (i == 0){
                res = Math.max(res, cnt);
                cnt =0;
            } else {
                cnt++;
            }
        }
        return Math.max(res, cnt);
    }
}