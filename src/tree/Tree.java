import java.util.*;
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
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
    //Leaf Node Sum- Thought of a question and solved it
    public List<List<Integer>> levelOrder2(TreeNode root) {
        Queue<TreeNode> q= new LinkedList<TreeNode>();
        List<List<Integer>> resultList = new LinkedList<List<Integer>>();
        if(root ==null){
            return resultList;
        }
        q.offer(root);
        int sum=0;
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
                if(q.peek().left==null && q.peek().left==null)
                {
                    sum+=q.peek().val;
                }
                sub.add(q.poll().val);
            }
            resultList.add(sub);
        }
        System.out.println(sum);
        return resultList;
    }

    //iterative preorder traversal
    public List<Integer> preorderTraversal(TreeNode root) {
        
        List<Integer> result = new ArrayList<>();
        if(root==null){
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        
        while(!stack.isEmpty()){
            root = stack.pop();
            result.add(root.val);
            if(root.right!=null){
                stack.push(root.right);
            }
            if(root.left!=null){
                stack.push(root.left);
            }
        }
        return result;
    }
}
