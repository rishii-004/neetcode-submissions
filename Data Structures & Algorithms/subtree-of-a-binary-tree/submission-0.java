class Solution {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        // subRoot is empty → always a subtree
        if (subRoot == null) {
            return true;
        }

        // root is empty, but subRoot isn't
        if (root == null) {
            return false;
        }

        // Check if current tree matches subRoot
        if (isSameTree(root, subRoot)) {
            return true;
        }

        // Search left and right
        return isSubtree(root.left, subRoot)
            || isSubtree(root.right, subRoot);
    }

    private boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }

        if (p == null || q == null) {
            return false;
        }

        if (p.val != q.val) {
            return false;
        }

        return isSameTree(p.left, q.left)
            && isSameTree(p.right, q.right);
    }
}
