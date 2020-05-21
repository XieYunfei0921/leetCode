public class ListNodeMerge {

	static class ListNode{
		int val;
		ListNode next;
		ListNode(int x){
			this.val=x;
		}

	}

	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode l3 = new ListNode(-1),ans=l3;
		while(l1!=null && l2!=null){
			if(l1.val<l2.val){
				l3.next=new ListNode(l1.val);
				l1=l1.next;
			} else{
				l3.next=new ListNode(l2.val);
				l2=l2.next;
			}
			l3=l3.next;
		}
		while(l1!=null){
			l3.next=new ListNode(l1.val);
			l1=l1.next;
			l3=l3.next;
		}
		while(l2!=null){
			l3.next=new ListNode(l2.val);
			l2=l2.next;
			l3=l3.next;
		}
		return ans.next;
	}

	public static void main(String[] args) {
		ListNode l1=new ListNode(1);
		l1.next=new ListNode(2);
		l1.next.next=new ListNode(4);
		ListNode l2=new ListNode(1);
		l2.next=new ListNode(3);
		l2.next.next=new ListNode(4);
		ListNode l3 = mergeTwoLists(l1, l2);
		while (l3!=null){
			System.out.print(l3.val+"\t");
			l3=l3.next;
		}
	}
}
