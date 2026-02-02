class Pair{
    int first;
    int sec;

    Pair(int first,int sec){
        this.first = first;
        this.sec = sec;
    }
}
class Solution {
    public int[][] merge(int[][] arr) {
    //my thinking
    /*
    1.sort the input on the basis of first no
    2.then use stack
    3.put first in stack and then check if
        contained h then skip
        non overlap h then add in staqck
        overlap h then replace the second value of interval in stack with the cur interval ka end

        4.at the end fill the ans arr
        */ 
      


     Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));
     /**
     Part	Meaning
Arrays.sort()	=Java’s sorting method
(a, b)	=two rows being compared
->=	lambda arrow
Integer.compare()=	actual comparison logic */


     Stack<Pair> st = new Stack<>();
      st.add(new Pair(arr[0][0],arr[0][1]));
 
     for(int i=1; i<arr.length;i++){
        int val1 = arr[i][0];
        int val2 = arr[i][1];

        Pair p = st.peek();
        int mine1 = p.first;
        int mine2 = p.sec;



        if(mine2>=val1 && mine2<val2){
            st.pop();
            st.add(new Pair(mine1,val2));
        }else if(mine2 < val1){
            st.add(new Pair(val1,val2));
        }else{
            continue;
        }
     }

            
      int n = st.size();
    int[][] ans = new int[n][2];

for (int i = n - 1; i >= 0; i--) {
    Pair p = st.pop();      // pop from stack
    ans[i][0] = p.first;
    ans[i][1] = p.sec;
}
 return ans;

              
    
    }
}