//so we are firslty doing it with the brute force
class Pair{
    int first;
    int second;
    public Pair(int first,int second){
        this.first =first;
        this.second = second;
    }
}
class LRUCache {
    int capacity;
    ArrayList<Pair> list;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.list = new ArrayList<>();
    }
    
    public int get(int key) {
        //iterate on arraylist
         for(int i=0; i<list.size();i++){
            Pair p = list.get(i);
//if you found the key
            if(p.first == key){
                //move it to last;
                list.remove(i);
                list.add(new Pair(key,p.second));
                //return the value
                return p.second;
            }
         }
            return -1; //else if you didnot found key
         
    }
    public void put(int key, int value) {

        //firslty check if key is present if yes then remove ith pair and at it to last
            for(int i=0; i<list.size();i++){
                Pair p = list.get(i);
                int mykey = p.first;
                int myval = p.second;

                if(mykey == key){
                    //remove this pair 
                    list.remove(i);
                    list.add(new Pair(key,value));
                    return;
                }}


                //agar key present nhi h toh firstly check the capacity agar vo full h toh remove topmost pair
                    //check the size of the list
                    if(list.size() == capacity){
                        list.remove(0);
                    }

                    //either capacity is full and you empty it
                    //or there is spac efrom starting add the new pair at the back of arraylist
                    list.add(new Pair(key,value));
                   
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */