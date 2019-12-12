public class day104 {
    /**
     * 查询树的深度
     */

    public static void main(String[] args) {
        TreeNode treeNode = TreeUtils.createTreeNode();
        System.out.println(findDeep(treeNode));

    }

    public static Integer findDeep(TreeNode treeNode) {
        //出口
        if (treeNode == null){
            return 0;
        }

        Integer deepLeft = findDeep(treeNode.left);
        Integer deepRight = findDeep(treeNode.right);

       return Math.max(deepLeft, deepRight)+1;

    }
}
