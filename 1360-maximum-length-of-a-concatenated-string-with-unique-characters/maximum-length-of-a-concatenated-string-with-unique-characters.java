class Solution {
 HashSet<Character> hs = new HashSet<>();
   //did on my own

     public boolean valid(HashSet<Character> hs,int j,List<String> arr){
        //check krta h ki kya ith index pr jo str h uske every char unique h na
        String str = arr.get(j);
        //for(int i=0; i<str.length();i++){
            // if(!hs.contains(str.charAt(i))){
            //        hs.add(str.charAt(i));
            // }else{
            //         return false;
            // } here example we had uniq in hs and now we are check is pkmi str is valid or not but bcz i check and add add same time till i reach i have already added char = pkm but bcz pkmi has i i should add pkm in our hs also

       // }



       for(int i=0; i<str.length();i++){
        if(hs.contains(str.charAt(i)))return false;
       }

       adder(str,hs);
       return true;
     }

     public void adder(String str, HashSet<Character> hs){
        //this will example you have aa then exampel you add  a then later in loop if you dont add another  a bcz of suplcate 
     //   so phle wala a yhi rh gya
   
        hs.add(str.charAt(0));
      for(int i=1;i<str.length();i++){
          if(!hs.contains(str.charAt(i))){
            hs.add(str.charAt(i));
          }else {
            remover(str,hs);
            break;
          }
      }


     }
      public void remover(String str, HashSet<Character> hs){
        //loop over str and remove its presence from hs

        for(int i=0;i<str.length();i++){
            if(hs.contains(str.charAt(i))){
                hs.remove(str.charAt(i));
            }
        }
      }
    public int solver(int i,List<String> arr, int n){
        if(i==n)return hs.size();
        
        int npick= solver(i+1,arr,n);
        int pick = 0;
       
        if(valid(hs,i,arr) == true){ //check i th str hs mein hb ya nhi every char
             pick = solver(i+1,arr,n);
              remover(arr.get(i),hs);
        }
       
        

        return Math.max(pick,npick);

    }
    public int maxLength(List<String> arr) {
        //i am thinking something like i will do pickup and npick wlai thing and at every tieme we pick we will check hashset me vo value h ya nhi
        int n  = arr.size();
        
        return solver(0,arr,n);
    }
}