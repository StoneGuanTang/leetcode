package tree;

import java.util.Objects;

/**
 * 二叉树
 * create by tgss on 2020/12/18 14:50
 **/
public class BinarySearchTree {

    private TreeNode root;

    public TreeNode find(int data) {
        TreeNode p = root;
        while (null != p) {
            if (data > p.getVal()) {
                p = p.getRight();
            } else if (data < p.getVal()) {
                p = p.getLeft();
            } else {
                return p;
            }
        }
        return null;
    }

    public void insert(int data) {
        if (Objects.isNull(root)) {
            root = new TreeNode(data);
            return;
        }
        TreeNode p = root;
        while (null != p) {
            if (data >= p.getVal()) {
                if (null == p.getRight()) {
                    p.setRight(new TreeNode(data));
                    return;
                } else {
                    p = p.getRight();
                }
            } else {
                if (null == p.getLeft()) {
                    p.setLeft(new TreeNode(data));
                    return;
                } else {
                    p = p.getLeft();
                }
            }
        }
    }

    public void delete(int data) {
        TreeNode p = root;
        TreeNode pp = null;
        while (Objects.nonNull(p) && p.getVal() != data) {
            pp = p;
            if (data > p.getVal()) {
                p = p.getRight();
            } else {
                p = p.getLeft();
            }
        }

        if (Objects.isNull(p)) {
            return;
        }

        boolean hasLeft = Objects.nonNull(p.getLeft());
        boolean hasRight = Objects.nonNull(p.getRight());
        // 要删除的节点有两个。从右子数中查找最小节点，替换要删除的节点
        if (hasLeft && hasRight) {
            TreeNode minP = p.getRight();
            TreeNode minPP = p;
            while (minP.getLeft() != null) {
                minPP = minP;
                minP = minP.getLeft();
            }
            p.setVal(minP.getVal());
            p = minP;
            pp = minPP;
        }

        TreeNode child;
        if (p.getLeft() != null) {
            child = p.getLeft();
        } else if (p.getRight() != null) {
            child = p.getRight();
        } else {
            child = null;
        }

        if (pp == null) {
            root = child;
        } else if (pp.getLeft() == p) {
            pp.setLeft(child);
        } else {
            pp.setRight(child);
        }
    }

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(1);
        tree.insert(12);
        tree.insert(45);
        tree.insert(23);

        TreeNode findTree = tree.find(12);
        System.out.println("before delete findTree.getVal():" + tree.getVal(findTree));

        tree.delete(12);

        findTree = tree.find(12);
        System.out.println("after delete findTree.getVal():" + tree.getVal(findTree));
    }

    private int getVal(TreeNode tree) {
        return Objects.isNull(tree) ? 0 : tree.getVal();
    }


}
