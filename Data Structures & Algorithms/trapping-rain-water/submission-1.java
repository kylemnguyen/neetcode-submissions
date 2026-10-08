class Solution {
    public int trap(int[] height) {
        if(height.length == 0) return 0;

        // make 2 arrays, prefix and suffix
        // prefix : tallest block to the left of index[i]
        // suffix: tallest block to teh right of index [i]

        int max = 0;
        int[] prefix = new int[height.length];
        int[] suffix = new int[height.length];
        prefix[0] = height[0];
        suffix[height.length - 1] = height[height.length - 1];
        for(int i = 1; i < height.length; i++) {
            prefix[i] = Math.max(prefix[i-1], height[i]);
        }
        for(int i = height.length - 2; i >= 0; i--) {
            suffix[i] = Math.max(suffix[i+1], height[i]);
        }
        for(int i = 0; i < height.length; i++) {
            max += Math.min(prefix[i], suffix[i]) - height[i];
        }

        return max;
    }
}
