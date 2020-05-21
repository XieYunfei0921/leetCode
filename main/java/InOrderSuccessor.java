public class InOrderSuccessor {

	/**
	 * @param root 给定的树
	 * @param p 给定树的节点
	 * @return
	 */
	public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
		if(root==null || p==null) return null;
		if(root.val>p.val){
			TreeNode left=inorderSuccessor(root.left,p);
			return left==null?root:left;
		}
		else
			return inorderSuccessor(root.right,p);
	}


	public static void main(String[] args) {

	}
}
