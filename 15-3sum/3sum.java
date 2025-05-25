//doing using better solution 
//n2 complexity better than n3
//here our goal was to remove the third loop of k that is i loop, j loop ,then k loop
// so what we have done that we want that  nums[i]+nums[j]+nums[k] = 0;
//so now if we knew value of nums[] and nums[j];
//then we can what can be value of nums3 =  nums[k] = -(nums[i] + nums[j]);
//so while loop i and j we kept on storing j in a set1 or more specifically
//for one iteration of i we store everything in between i and j and try to find if we are able to make ans
//once we made ans i.e nums[i]+nums[j]+nums[k] = 0 we sort all these value and check if they are present in finalans set2
//if they are not present than we add them 

//and also after every iteration of i we empty the set1


//did withthe help of intiuition of striver

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<Integer> set1 = new HashSet<>();
        Set<List<Integer>> set2 = new HashSet<>();
        int n = nums.length;
        for(int i=0;i<n;i++){
            for(int j = i+1; j<n; j++){
                int num1 = nums[i];
                int num2 = nums[j];
                int num3 = -(nums[i]+nums[j]);
                if(set1.contains(num3)){
                    ArrayList<Integer> ls = new ArrayList<>();
                    ls.add(num1);
                    ls.add(num2);
                    ls.add(num3);
                    Collections.sort(ls);
                    if(!set2.contains(ls))set2.add(ls);
                }
                set1.add(num2);

            }
            //empty the set1;
            set1.clear();
        }


        //loop ober set and collect your ans
     List<List<Integer>> ans = new ArrayList<>(set2);
     return ans;
    }
}