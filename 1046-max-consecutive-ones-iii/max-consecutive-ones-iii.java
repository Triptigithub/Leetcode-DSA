//here we used the concept of variable size sliding window
//we calculate cnof0
//agar vo given cnt se chota h then uincrease window lengtth
//agar equal h then it can be possible ans so store the window size and then slide the window
//agar cnt bda h tho i++ till cntof0 bda h


///////AS HERE WE ARE FGIVEN WE CAN ROTATE AT MOST K TIMES THEREFORE WE MERGE THE LESS THAN AND EQUAL TO CONDITION
class Solution {
    public int longestOnes(int[] arr, int k) {
        int cntof0 = 0;
        int ans = 0;

        int i=0;int j=0;
        while(j<arr.length){
            //do intitial calculation
            if(arr[j] == 0)cntof0++;

            if(cntof0 <= k){
               
                //when cnt is equal OR LESS THAN we can get possible ans so store and ans slide the window
                ans = Math.max(ans,j-i+1);
                j++;

            }else if (cntof0 > k){
            //when cntof0 id bigger than given cnt
                while(cntof0 > k){
                    if(arr[i] == 0)cntof0--;  //we are subtracting cntof0 whenever we are getting 0 in window
                    i++;
                }
                j++;

            }

        }

        return ans;
    }
}