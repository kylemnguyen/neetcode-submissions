class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        int[] ans = new int[2];
        for(int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
            if(freqMap.get(num) > ans[1]) {
                ans[0] = num;
                ans[1] = freqMap.get(num);
            }
        }

        return ans[0];
    }
}