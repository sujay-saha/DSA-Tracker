import java.util.*;

public class Tree {
    public static void main(String[] args) {
      
    }
//Level Order Traversal
//Link: https://leetcode.com/problems/binary-tree-level-order-traversal/
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> q= new LinkedList<TreeNode>();
        List<List<Integer>> resultList = new LinkedList<List<Integer>>();
        if(root ==null){
            return resultList;
        }
        q.offer(root);
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> sub = new LinkedList<Integer>();
            for(int i =0;i<size;i++){
                if(q.peek().left!=null){
                    q.offer(q.peek().left);
                }
                if(q.peek().right!=null){
                    q.offer(q.peek().right);
                }
                sub.add(q.poll().val);
            }
            resultList.add(sub);
        }
        return resultList;
    }
}
