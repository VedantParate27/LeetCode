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
class Solution {
    public void flatten(TreeNode root) {
        List<TreeNode> result = new ArrayList<>();
        solution(result, root);

        for(int i=0; i<result.size(); i++){
            TreeNode node = result.get(i);
            node.left =null;
            if(i+1 < result.size()){
                node.right = result.get(i+1);
            }
            else node.right = null;
        }
    }

    private void solution(List<TreeNode> result, TreeNode node){
        if (node == null)   return;

        result.add(node);
        solution(result, node.left);
        solution(result, node.right);
    }
}