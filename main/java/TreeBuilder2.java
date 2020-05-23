public class TreeBuilder2 {

	public static TreeNode buildTree(int[] inorder, int[] postorder) {
		return buildSubtree(inorder,0,inorder.length-1,postorder,0,postorder.length-1);
	}

	public static TreeNode buildSubtree(int[] inorder,int IS,int IE,
	                                    int[] postorder,int PS,int PE){
		if(PS>PE || IS>IE) return null;
		TreeNode root=new TreeNode(postorder[PE]);
		int index=-1;
		for (int i = IS; i <=IE ; i++) {
			if(inorder[i]==root.val){
				index=i;
				break;
			}
		}
		int len=index-IS;
		root.left=buildSubtree(inorder,IS,index-1,postorder,PS,PS+len-1);
		root.right=buildSubtree(inorder,index+1,IE,postorder,PS+len,PE-1);
		return root;
	}

	public static void preOrder(TreeNode node){
		if(node==null) return;
		System.out.println(node.val);
		preOrder(node.left);
		preOrder(node.right);
	}

	public static void main(String[] args) {
		int[] inorder=new int[]{9,3,15,20,7};
		int[] postorder=new int[]{9,15,7,20,3};
		TreeNode root = buildTree(inorder, postorder);
		preOrder(root);
	}
}
