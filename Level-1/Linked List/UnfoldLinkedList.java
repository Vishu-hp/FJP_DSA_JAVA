import java.util.*;

class Main {
    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    
    ListNode reverse(ListNode head){
        ListNode curr=head, next=null, prev=null;

        while(curr!=null){
            next = curr.next;

            curr.next = prev;

            prev = curr;
            curr = next;
        }
        return prev;
    }

    public static void unfold(ListNode head) {
        ListNode fh = head;
        ListNode fp = fh;
    
        ListNode sh = head.next;
        ListNode sp = sp;
        
        while(sp!=null && sp.next!=null){
            ListNode f = sp.next;
            
            fp.next = f;
            sp.next = f.next
            
            fp = fp.next;
            sp = sp.next;
        }
        
        fp.next = null;
        
        sh = reverse(sh);
        
        fp.next = sh;
    }

    static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        while (n-- > 0) {
            prev.next = new ListNode(scn.nextInt());
            prev = prev.next;
        }

        ListNode head = dummy.next;
        unfold(head);
        printList(head);
    }
}
