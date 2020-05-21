public class TwoNumberAdd {

	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode head=new ListNode(-1);
		ListNode ans=head;
		int sign=0;
		while (l1!=null || l2!=null){
			// 填充l2,如果l2是短链表
			if(l2==null) l2=new ListNode(0);
			if(l1==null) l1=new ListNode(0);
			head.val=(l1.val+l2.val+sign)%10;
			sign=(l1.val+l2.val+sign)/10;
			if(!(l1.next==null && l2.next==null))
				head.next=new ListNode(-1);
			else{
				if(sign==1)
					head.next=new ListNode(1);
			}
			l1=l1.next;
			l2=l2.next;
			head=head.next;
		}
		return ans;
	}

	public static void main(String[] args) {
		ListNode l1=new ListNode(2);
		l1.next=new ListNode(4);
		l1.next.next=new ListNode(3);
		ListNode l2=new ListNode(5);
		l2.next=new ListNode(6);
		l2.next.next=new ListNode(7);
		ListNode node = addTwoNumbers(l1, l2);
		while (node!=null){
			System.out.print(node.val+"\t");
			node=node.next;
		}
	}
}
