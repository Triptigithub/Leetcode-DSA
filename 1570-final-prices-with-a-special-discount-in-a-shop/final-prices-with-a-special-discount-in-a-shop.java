class Solution {
    //in order to solve this problem find the next smaller element from right and fill up array with values and if no smaller element present mark 0
    //now subtract the current indx value with the nsr array value and fill up the final ans arr
    public int[] finalPrices(int[] prices) {
        //firstly generate nsr
       ArrayList<Integer> nsr = new ArrayList<>();
       Stack<Integer> st = new Stack<>();
        for(int i=prices.length-1; i>=0; i--){
            if(st.isEmpty()){
                nsr.add(0);
                st.push(prices[i]);

            }else{
                if(st.peek() <= prices[i]){
                    nsr.add(st.peek());
                    st.push(prices[i]);
                }else if(st.peek() > prices[i]){
                      while(!st.isEmpty() && st.peek() > prices[i]){
                            st.pop();        
                      }

                      if(st.isEmpty()){
                        nsr.add(0);
                      }else if(st.peek() <= prices[i]){
                        nsr.add(st.peek());

                      }
                      st.push(prices[i]);
                }


            }
        }

        Collections.reverse(nsr);
        int[] finalans = new int[prices.length];
        for(int i=0;i<prices.length;i++){
            finalans[i] = prices[i] - nsr.get(i);
        }

        return finalans;
    }
}