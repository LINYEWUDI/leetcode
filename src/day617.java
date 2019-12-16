public class day617 {

    public static void main(String[] args) {

    }
    public static TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 != null && t2 != null){
            t1.val = t1.val+t2.val;
        }

        if (t1 == null || t2 == null){

        }

        mergeTrees(t1.left,t1.right);
        mergeTrees(t2.left,t2.right);

        return t1;
    }
}
