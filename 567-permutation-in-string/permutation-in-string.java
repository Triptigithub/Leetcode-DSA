class Solution {
    public boolean checkInclusion(String s1, String s2) {
       //firstly fill the hashmap with the string 1
       HashMap<Character,Integer> firstmap= new HashMap<>();
       for(int i=0; i<s1.length();i++){
          if(firstmap.containsKey(s1.charAt(i))){
            firstmap.put(s1.charAt(i),firstmap.get(s1.charAt(i))+1);
          }else{
            firstmap.put(s1.charAt(i),1);
          }
       }


       //no we have filled the map with 1st string character and its frequency
       //now
       HashMap<Character,Integer> map = new HashMap<>();
       int k = s1.length();


       int i=0;
       int j=0;
       while(j<s2.length()){

        //do calculation fill the current element in secodmap 
        if(map.containsKey(s2.charAt(j))){
            map.put(s2.charAt(j),map.get(s2.charAt(j))+1);
        }else{
            map.put(s2.charAt(j),1);
        }


          if(j-i+1 < k ){
            j++;
          }else if(j-i+1 == k){

            //compute ans
                if( firstmap.equals(map)  == true)return true;
                

            //resolve i
             char ch = s2.charAt(i);
             if(map.containsKey(ch)){
                int cnt = map.get(ch);

                if(cnt<=1){
                    map.remove(ch);
                }else{
                   cnt--;
                   map.put(ch,cnt);
                }


              }
              i++;
              



              //slide winodw 
              j++;


          }
          }
       
       return false;
    }
}

/**
 * 
 * 
 * 
 * if(map.containsKey(s2.charAt(j))){
 * map.put(s2.charAt(j),map.get(s2.charAt(j))+1);
 * }else{
 * map.put(s2.charAt(j),1);
 * }
 * 
 * if(map.size() < l1){
 * j++;
 * }else if(map.size() == l1){
 * if( firstmap.equals(map) == true)return true;
 * else j++;
 * }else if(map.size() > l1){
 * //now shrink the map
 * 
 * 
 * while(map.size() >l1){
 * char ch = s2.charAt(i);
 * 
 * 
 * if(map.containsKey(ch)){
 * int cnt = map.get(ch);
 * 
 * if(cnt<=1){
 * map.remove(ch);
 * }else{
 * cnt--;
 * map.put(ch,cnt);
 * }
 * 
 * i++;
 * }
 * 
 * if(firstmap.equals(map) == true)return true;
 * else j++;
 * 
 * }
 * 
 * }
 */