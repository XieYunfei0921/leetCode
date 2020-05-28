package test;

public class GcNode {

	GcNode(int x){this.val=x;}

	private int val;

	// 表示当前节点所依赖的阶段
	private GcNode[] dependencies;

	// bool型变量,表示当前变量是否被访问过,遍历图的时候使用
	private boolean isVisited=false;

	/**
	 * 深度搜索图
	 * @param root 深度搜索的根节点
	 */
	public static void traversal(GcNode root){
		root.isVisited=true;
		System.out.println(root.val);

		if(root.dependencies==null) return;
		int size=root.dependencies.length;
		if(size==0) return;

		for (int i = 0; i < size; i++) {
			if(!root.dependencies[i].isVisited)
				traversal(root.dependencies[i]);
		}
	}

	public static void main(String[] args) {
		GcNode[] nodes=new GcNode[10];
		for (int i = 0; i <10 ; i++) {
			nodes[i]=new GcNode(i+1);
		}
		GcNode root=nodes[0];
		root.dependencies=new GcNode[2];
		root.dependencies[0]=nodes[1];
		root.dependencies[1]=nodes[2];
		root.dependencies[0].dependencies=new GcNode[4];
		root.dependencies[1].dependencies=new GcNode[1];
		root.dependencies[0].dependencies[0]=nodes[3];
		root.dependencies[0].dependencies[1]=nodes[4];
		root.dependencies[0].dependencies[2]=nodes[5];
		root.dependencies[1].dependencies[0]=nodes[6];
		root.dependencies[0].dependencies[3]=nodes[6];
		traversal(root);
	}
}
