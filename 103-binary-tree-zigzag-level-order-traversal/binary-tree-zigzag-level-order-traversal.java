import java.util.*;
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>>ans = new ArrayList<>();
        Queue<TreeNode> q  = new LinkedList<>();
        if(root == null)return ans;

        
        q.add(root);
        boolean flag = true;


        while(!q.isEmpty()){
            List<Integer> dum =  new ArrayList<>();
            
            int size = q.size();
            for(int i=0;i<size;i++){
                TreeNode node = q.poll();
                dum.add(node.val);

                if(node.left!= null)q.add(node.left);
                if(node.right!= null)q.add(node.right);
            }
            if(flag == false){
                //add in reverse order
                List<Integer> ls = new ArrayList<>();
                for(int i=dum.size()-1; i>= 0 ;i--){
                    ls.add(dum.get(i));
                }
                ans.add(ls);
                
            }else{
                ans.add(dum);
            }
            if(flag == true)flag =false;
            else flag = true;
        }
        return ans;
    }
}