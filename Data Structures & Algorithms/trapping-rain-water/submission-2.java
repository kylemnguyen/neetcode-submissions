class Solution {
    public int trap(int[] height) {
        if(height.length == 0) return 0;

        int[] prefix = new int[height.length];
        int[] suffix = new int[height.length];
        int max = 0;
        prefix[0] = height[0];
        suffix[height.length - 1] = height[height.length - 1];

        for(int i = 1; i < height.length; i++) {
            prefix[i] = Math.max(prefix[i - 1], height[i]);
        }  

        for(int j = height.length - 2; j >= 0; j--) {
            suffix[j] = Math.max(suffix[j + 1], height[j]);
        }

        for(int i = 0; i < height.length; i++) {
            max += Math.min(prefix[i], suffix[i]) - height[i];
        };

        return max;
    }
}
