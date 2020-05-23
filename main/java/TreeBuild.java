public class TreeBuild {

	/**
	 * 二叉树还原
	   前序:
	    root left right
	   中序
	    left root right
	 * @param preorder
	 * @param inorder
	 * @return
	 */
	public static TreeNode buildTree(int[] preorder, int[] inorder) {
		return buildSubTree(preorder,0,preorder.length-1,inorder,0,inorder.length-1);
	}

	private static TreeNode buildSubTree(int[] preorder, int PS, int PE, int[] inorder, int IS, int IE) {
		if(PS>PE || IS>IE) return null;
		if(!(PS>=0 && PS<preorder.length)) return null;
		TreeNode root=new TreeNode(preorder[PS]);
		int index=-1;
		for (int i = IS; i <=IE ; i++) {
			if(inorder[i]==root.val){
				index=i;
				break;
			}
		}
		int len=index-IS+1;
		root.left=buildSubTree(preorder,PS+1,PS+len-1,inorder,IS,index-1);
		root.right=buildSubTree(preorder,PS+len,PE,inorder,index+1,IE);
		return root;
	}

	public static void postorder(TreeNode root){
		if(root==null) return;
		postorder(root.left);
		postorder(root.right);
		System.out.println(root.val);
	}

	public static void main(String[] args) {
		int[]  preorder = {3,9,20,15,7};
		int[]  inorder = {9,3,15,20,7};
		TreeNode root = buildTree(preorder, inorder);
		postorder(root);
	}
}