class Solution {
      int global;
    public void combine(int low,int mid,int high,int[] arr){
      ArrayList<Integer> temp = new ArrayList<>(); // temporary array
        int left = low;      // starting index of left half of arr
        int right = mid + 1;   // starting index of right half of arr

        //storing elements in the temporary array in a sorted manner//

        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                temp.add(arr[left]);
                left++;
            } else {
                temp.add(arr[right]);
                global+=mid-left+1;
                right++;
            }
        }

        // if elements on the left half are still left //

        while (left <= mid) {
            temp.add(arr[left]);
            left++;
        }

        //  if elements on the right half are still left //
        while (right <= high) {
            temp.add(arr[right]);
            right++;
        }

        // transfering all elements from temporary to arr //
        for (int i = low; i <= high; i++) {
            arr[i] = temp.get(i - low);
        }
    
        
    }
    public void merge(int[] arr,int left,int right){
        if(left>=right)return;
        int mid = (left+right)/2;
        merge(arr,left,mid);
        merge(arr,mid+1,right);
        combine(left,mid,right,arr);
        
    }
    public boolean isIdealPermutation(int[] arr) {
        int n = arr.length-1;
        int local = 0;
        for(int i=0; i<n; i++){
            if(arr[i]>arr[i+1])local++;
        }
        global =0; 
        merge(arr,0,n);
        return global == local;
    }
}