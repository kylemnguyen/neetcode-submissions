class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i : nums){
            if(map.containsKey(Integer.valueOf(i))) {
                return true;
            } else {
                map.put(Integer.valueOf(i), 1);
            }
        }

        return false;

    }
}