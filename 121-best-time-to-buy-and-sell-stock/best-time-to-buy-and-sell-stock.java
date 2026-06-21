class Solution {
    public int maxProfit(int[] arr) {
        int n = arr.length;
        int max = 0;
        int min = arr[0];
        int ans = 0;
        
        for(int i=1; i<n;i++){
            max = arr[i];

            ans = Math.max(ans,max-min);
            min = Math.min(min,arr[i]);

        }
        return ans;
            }
}