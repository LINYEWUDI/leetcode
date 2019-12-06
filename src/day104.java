public class day104 {
    /**
     * 查询树的深度
     */

    public static void main(String[] args) {
        System.out.println(findDeep(new TreeNode(10)));

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
