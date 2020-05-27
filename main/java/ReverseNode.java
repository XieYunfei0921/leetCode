public class ReverseNode {

	public static ListNode reverse(ListNode listNode){
		ListNode last=null,next;
		while (listNode!=null){
			// 找到正序下一个节点
			next=listNode.next;
			// 设置当前节点的后继节点
			listNode.next=last;
			// 将当前节点置为上一个节点
			last=listNode;
			// 移动到下一个节点
			if(next!=null)
				listNode=next;
			else
				break;
		}
		return listNode;
	}

	public static void traversal(ListNode listNode){
		while (listNode!=null){
			System.out.println(listNode.val);
			listNode=listNode.next;
		}
	}

	public static void main(String[] args) {
		ListNode node = new ListNode(1);
		node.next=new ListNode(2);
		node.next.next=new ListNode(3);
		node.next.next.next=new ListNode(4);
		ListNode ans = reverse(node);
		traversal(ans);
	}
}
