package tree;

import java.util.Objects;

/**
 * 输入一棵二叉树的根节点，求该树的深度。从根节点到叶节点依次经过的节点（含根、叶节点）形成树的一条路径，最长路径的长度为树的深度。
 *
 * 例如：
 *
 * 给定二叉树 [3,9,20,null,null,15,7]，
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最大深度 3 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/er-cha-shu-de-shen-du-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * create by tgss on 2020/6/18 15:35
 **/
public class Test1 {

    public static int getDepth(TreeNode treeNode) {
        if (Objects.isNull(treeNode)) {
            return 0;
        }
        int left = getDepth(treeNode.getLeft());
        int right = getDepth(treeNode.getRight());
        return Math.max(left, right) + 1;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(0);
        TreeNode left = new TreeNode(1);
        TreeNode right = new TreeNode(2);
        treeNode.setLeft(left);
        treeNode.setRight(right);
        System.out.println(getDepth(treeNode));
    }

}
