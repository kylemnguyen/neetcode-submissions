class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int gasSum = 0; 
        int costSum = 0;
        for(int g : gas) gasSum+=g;
        for(int c : cost) costSum+=c;
        if(gasSum < costSum) return -1;
        
        int total = 0;
        int ans = 0;

        for(int i = 0; i < cost.length; i++) {
            total += gas[i] - cost[i];
            if(total < 0) {
                total = 0;
                ans = (i + 1 >= cost.length) ? 0 : i + 1;
            }
        }

        return ans;
    }
}
