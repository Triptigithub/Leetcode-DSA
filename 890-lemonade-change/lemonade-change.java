//5 h agar bill just do 5++;
//10 h agar bill just do ek 5 minus and 10++
//20 h agar bill   i) ya toh 3 five ho     ii) ek 5 and 1 ten ho


class Solution {
    public boolean lemonadeChange(int[] bills) {
        int five = 0;
        int ten = 0;
        int twenty = 0;

        for(int i=0;i<bills.length;i++){
            if(bills[i] == 5){
                five++;
            }else if(bills[i] == 10){
                if(five==0){
                    return false;
                }

                five--;
                ten++;
            }else if(bills[i] == 20){
                 if (five!=0 && ten != 0){
                    five--;
                    ten--;
                    twenty++;
                }else if(five >= 3 ){
                    five = five-3;
                    twenty++;
                }else{
                    return false;
                }
                    
                    
                    
                    
                    
                    
           
            }
        }
        return true;
    }
}