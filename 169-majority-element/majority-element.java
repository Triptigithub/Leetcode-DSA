//code vby me

class Solution {
    public int majorityElement(int[] nums) {
        //moores voting algo
        //here what this algo is say in order to find the majority element -> (element which appear more than n/2 times) in an array 
        //example arr = 2 2 4 3 2 2 5 2 4 here len =10 and if any element is majority thrn it should appear altleast 6 time or more that is n/2 se jyada
        //so start with element =2 and cnt1 ->2     //increse cnt as num =el
        //el =2 cnt=2;  ->2          ..increas as num = el
        //el =2  cnt =1  ->4          ..decreas cnt as num1= el
        //el = 2  cnt =0    ->3        ..decreas
        //el =2  cnt = 1    ->2        ..as  num = el same cnt++;
        //el = 2  cnt = 2 ->2          ..agauin cnt++;
        //el =2  cnt = 1 ->5             ..decrease
        //el = 2  cnt =2  ->2            .. increase
        //el = 2   cnt = 1  ->4           .decrease

        //so at last cnt =1 and el =2 return el;

        int el = nums[0];
        int cnt =1;

        for(int i=1; i<nums.length; i++){
              if(cnt == 0){
                el = nums[i];
                cnt++;
              }else{
                 if(nums[i] == el){
                cnt++;
                 }else{
                cnt--;
                if(cnt ==0){
                    el = nums[i];
                }
              }

            }
        }

        if(cnt!=0)return el;
        return 0;
    }
}