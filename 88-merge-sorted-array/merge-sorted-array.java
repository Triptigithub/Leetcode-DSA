class Solution {

    //there is liitle twik in this guestion here we are given that arr1 has lengtth of m+n
    //and arr2 is of len 2


    //if it is given that arr1 has len = n and arr2 as m
    //then what we will did
  //then we need to find the initial gap by arr1.len +arr2 len /2 and then use its floor
  ////after that place left pt at 0 and pt2 at gap of gap
  //then there may be three case 
  /**
  1. both left and right are in diff array ->swap(arr1,arr2,left,right-n);
  2. both left and right are in arr2 ->swap(arr2,arr2,left-n,right-n);
  3. both left and right are in arr1  ->swap(arr1,arr1,left,right);

  //then simply did left++ right++
  //make sure you break at gap=1;
  //and also after every iteration reduce the gap -> Math.ceil(gap/2);
  
  
  
  
  
  
   */

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int gap = (m + n + 1) / 2;

        while (gap > 0) {
            int i = 0, j = gap;

            while (j < (m + n)) {
                // Decide positions
                if (i < m && j < m) {
                    // both in nums1
                    if (nums1[i] > nums1[j]) {
                        int temp = nums1[i];
                        nums1[i] = nums1[j];
                        nums1[j] = temp;
                    }
                } else if (i < m && j >= m) {
                    // nums1 and nums2
                    if (nums1[i] > nums2[j - m]) {
                        int temp = nums1[i];
                        nums1[i] = nums2[j - m];
                        nums2[j - m] = temp;
                    }
                } else {
                    // both in nums2
                    if (nums2[i - m] > nums2[j - m]) {
                        int temp = nums2[i - m];
                        nums2[i - m] = nums2[j - m];
                        nums2[j - m] = temp;
                    }
                }
                i++;
                j++;
            }

            if (gap == 1) break;
            gap = (gap + 1) / 2;
        }

        // Copy sorted nums2 to nums1
        for (int i = 0; i < n; i++) {
            nums1[m + i] = nums2[i];
        }
    }
}
