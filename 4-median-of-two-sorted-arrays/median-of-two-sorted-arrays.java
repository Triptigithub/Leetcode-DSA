class Solution {
    static int nextGap(int gap) {
        if (gap <= 1) return 0;
        return (gap / 2) + (gap % 2); // ceil(gap/2)
    }

    // Merge function using Hive (Gap) method
    static void merge(int arr1[], int arr2[], int n, int m) {
        int gap = n + m;  // combined length

        for (gap = nextGap(gap); gap > 0; gap = nextGap(gap)) {
            int i, j;

            // Case 1: Compare elements in arr1
            for (i = 0; i + gap < n; i++) {
                if (arr1[i] > arr1[i + gap]) {
                    int temp = arr1[i];
                    arr1[i] = arr1[i + gap];
                    arr1[i + gap] = temp;
                }
            }

            // Case 2: Compare elements between arr1 and arr2
            for (j = (gap > n ? gap - n : 0); i < n && j < m; i++, j++) {
                if (arr1[i] > arr2[j]) {
                    int temp = arr1[i];
                    arr1[i] = arr2[j];
                    arr2[j] = temp;
                }
            }

            // Case 3: Compare elements in arr2
            if (j < m) {
                for (j = 0; j + gap < m; j++) {
                    if (arr2[j] > arr2[j + gap]) {
                        int temp = arr2[j];
                        arr2[j] = arr2[j + gap];
                        arr2[j + gap] = temp;
                    }
                }
            }
        }
    }







    static int getKthElement(int[] arr1, int[] arr2, int k) {
        int n = arr1.length;
        if (k < n) return arr1[k];
        else return arr2[k - n];
    }

    // Main median function
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        merge(nums1, nums2, nums1.length, nums2.length);

        int n = nums1.length;
        int m = nums2.length;
        int total = n + m;

        if (total % 2 == 1) { // odd length
            return getKthElement(nums1, nums2, total / 2);
        } else { // even length
            int mid1 = total / 2 - 1;
            int mid2 = total / 2;
            double val1 = getKthElement(nums1, nums2, mid1);
            double val2 = getKthElement(nums1, nums2, mid2);
            return (val1 + val2) / 2.0;
        }
    }

    // public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    //     // merge(nums1,nums2);
    //     // double val =  (nums1.length+nums2.length)/2;
    //     // double ceil = Math.ceil(val);
    //     // double floor = Maths.floor(val);
    //     // if(ceil==floor){
    //     //     if(ceil < nums1.length)return (double)arr1[ceil];
    //     //     else return(double)  arr2[(nums1.length+nums2.length)-ceil];
    //     // }else{
    //     //     //check kro ceil or floor konse array mei n them do valu1+valu2/2
    //     // }
    // }
}