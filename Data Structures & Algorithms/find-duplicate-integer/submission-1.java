class Solution {
    public int findDuplicate(int[] nums) {
        int len = nums.length;
        boolean[] idxArr = new boolean[len];
        int num = -1;
        for (int i = 0; i < len; i++) {
            if (idxArr[nums[i]] == true ) {
                num = nums[i];
                break;
            } else {
                idxArr[nums[i]] = true;   
            }
        }
        return num;
    }
}
