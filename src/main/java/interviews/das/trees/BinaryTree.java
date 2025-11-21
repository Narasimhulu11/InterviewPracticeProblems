package interviews.das.trees;


import java.util.ArrayList;
import java.util.List;

public class BinaryTree {

    public static void main(String[] args) {
        TreeNode leftNode = new TreeNode(2);
        TreeNode rightNode = new TreeNode(3);
        TreeNode treeNode= new TreeNode(1,leftNode,rightNode);
        TreeNode bstTest= new TreeNode(1,leftNode,null);

        System.out.println(isValidBST(bstTest));

        List<Integer> list1=getInorderTraversals(treeNode);
        List<Integer>  list2=getPreorderTraversal(treeNode);
        List<Integer>  list3=getPostorderTraversal(treeNode);
        List<List<Integer>> list4=levelOrder(treeNode);
    }


    private static List<Integer> getPreorderTraversal(TreeNode treeNode) {
       List<Integer> res= new ArrayList<>();
        if(treeNode!=null){
            res.add(treeNode.val);
            getPreorderTraversal(treeNode.left);
            getPreorderTraversal(treeNode.right);
        }
       return res;
    }



    private static List<Integer> getInorderTraversals(TreeNode treeNode) {
        List<Integer> res= new ArrayList<>();
        getInorderTraversal(treeNode,res);
        return res;
    }
    static void getInorderTraversal(TreeNode treeNode, List<Integer> res){
        if(treeNode==null)
            return;
        getInorderTraversal(treeNode.left,res);
        res.add(treeNode.val);
        getInorderTraversal(treeNode.right,res);
    }

    private static List<Integer> getPostorderTraversal(TreeNode treeNode) {
        List<Integer> res= new ArrayList<>();
        if(treeNode!=null){
            getPostorderTraversal(treeNode.left);
            getPostorderTraversal(treeNode.right);
            res.add(treeNode.val);
        }
        return res;
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        getLevelOrder(root,0,res);
        return res;
    }
    static void getLevelOrder(TreeNode root, int level, List<List<Integer>> res){
        if(root==null)
            return;

        if(res.size()<=level){
            res.add(new ArrayList<>());
        }
        res.get(level).add(root.val);
        getLevelOrder(root.left,level+1,res);
        getLevelOrder(root.right,level+1,res);
    }
    public static boolean isValidBST(TreeNode root) {
        return inOrder(root, Integer.MIN_VALUE);
    }
    static boolean inOrder(TreeNode root, Integer min){
        if(root==null)
            return true;
        if(!inOrder(root.left,min))
            return false;
        if(min>=root.val)
            return false;
        min=root.val;
        return inOrder(root.right,min);
    }
}
