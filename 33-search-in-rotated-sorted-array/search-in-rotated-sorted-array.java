class Solution {
    public int search(int[] arr, int target) {
        int n = arr.length;

        // Step 1: find pivot (index of minimum element)
        int low = 0, high = n - 1;
        int pivot = 0;
        while (low <= high) {
            if (arr[low] <= arr[high]) { // already sorted
                pivot = low;
                break;
            }
            int mid = low + (high - low) / 2;
            int next = (mid + 1) % n;
            int prev = (mid + n - 1) % n;

            if (arr[mid] <= arr[next] && arr[mid] <= arr[prev]) {
                pivot = mid;
                break;
            } else if (arr[mid] >= arr[low]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        // Step 2: normal binary search in correct half
        int ans = -1;
        if (target >= arr[pivot] && target <= arr[n - 1]) {
            ans = bs(arr, target, pivot, n - 1);
        } else {
            ans = bs(arr, target, 0, pivot - 1);
        }

        return ans;
    }

    // Binary search in range [low, high]
    public int bs(int[] nums, int target, int low, int high) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] < target) low = mid + 1;
            else high = mid - 1;
        }
        return -1;
    }
}
