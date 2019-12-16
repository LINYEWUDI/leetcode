/**
 * 合并二叉树
 */
public class day617 {

    /**
     * 思想：首先写出正常合并，不是递归的情况。无非分成四种情况
     * 1.合并时两个节点都有值，则两个节点的值相加
     * 2.t1有值，t2无值，则合并时就是t1
     * 3.t1无值，t2有值，则合并时为t2
     * 4.t1，t2都无值，则为空
     *
     * 每次传入t1的左子树和右子树,那么t1的左子树肯定是在这个左子树和t2的左子树中进行合并，
     * 一直到最后一个时，t1和t2的左或者右子树都是空，那么t1的左子树直接返回null
     *
     */
    public static TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 != null && t2 != null){
            t1.val = t1.val+t2.val;
        }

        if (t1 == null || t2 == null){
            if (t1 == null && t2 != null){
                return t2;
            }
            if (t1 != null && t2 == null){
                return t1;
            }
            if (t1 == null && t2 == null){
                return null;
            }
        }


        t1.left = mergeTrees(t1.left,t2.left);
        t1.right = mergeTrees(t1.right,t2.right);

        return t1;
    }
}
